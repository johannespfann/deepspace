package de.pfann.deepspace.fightsystem.chain

import de.pfann.deepspace.api.{AttackAction, Fightable}
import de.pfann.deepspace.fightsystem.core.{BlindAttackAction, FleetCoordinator}
import de.pfann.deepspace.log.Log


class AttackerBattleFieldState(attacker: AttackerState, defender: DefenderState, coordinator: FleetCoordinator) extends AttackerState {

  def startFight(): Unit = {

    Log.info(this, "   [Attacker phase]")

    while(coordinator.hasNextAttack() && defender.isAlive()) {
      Log.debug(this, " (startFight) coordinator.hasNextAttack - defender.isAlive -> attack defender")
      defender.attack(this,coordinator.getNextAttack())

    }

    Log.info(this, "   [Defender phase]")

    while(defender.hasNextAttack() && this.isAlive()) {
      Log.debug(this, " (startFight) defender.hasNextAttack - defender.isAlive -> attack defender with BlindAttackAction")
      defender.attack(this, new BlindAttackAction)
    }
  }

  override def attack(attackAction: AttackAction): Unit = {
    if(coordinator.isAlive()) {
      Log.info(this, " (Defender attacks Attacker) coordinator.isAlive -> attackFleet() with " + attackAction.getDemage())
      coordinator.attackFleet(attackAction)
    }
    else {
      Log.info(this, " (Defender attacks Attacker) coordinator.isNotAlive -> delegate attack")
      attacker.attack(attackAction)
    }
  }

  override def isAlive(): Boolean = {
    if(coordinator.isAlive()) {
      Log.debug(this, " (isAlive) - coordinator.isAlive")
      return true
    }
    attacker.isAlive()

  }

  override def getFleets(): List[Fightable] = {
    coordinator.getCurrentFleet()
  }


}
