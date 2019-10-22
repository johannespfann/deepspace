package de.pfann.deepspace.fightsystem.chain
import de.pfann.deepspace.api.{AttackAction, Fightable}
import de.pfann.deepspace.fightsystem.Log
import de.pfann.deepspace.fightsystem.core.FleetCoordinator


class DefenderBattleFieldState(defender: DefenderState, coordinator: FleetCoordinator) extends DefenderState {

  override def attack(aAttacker: AttackerState, attackAction: AttackAction): Unit = {

    if(coordinator.isAlive()){
      Log.info(this, " (Attacker attacks Defender) - coordinator.isAlive -> attackFleet() with " + attackAction.getDemage())
      coordinator.attackFleet(attackAction)


      Log.debug(this, " (attack) - attacker.isAlive - coordinator.isAlive")
      if(coordinator.hasNextAttack()) {
        Log.debug(this, " (attack) - attacker.isAlive - coordinator.hasNextAttack -> attack attacker")
        if(aAttacker.isAlive()) {
          aAttacker.attack(coordinator.getNextAttack())
        }
      }
    }
    else {
      Log.info(this, " (Attacker attacks Defender) - coordinator.isNotAlive -> delegate attack")
      defender.attack(aAttacker, attackAction)
    }
  }

  override def getFleets(): List[Fightable] = {
    coordinator.getCurrentFleet()
  }

  override def isAlive(): Boolean = {
    if(coordinator.isAlive()) {
      Log.debug(this, " (isAlive) - coordinator.isAlive")
      return true
    }
    Log.debug(this, " (isAlive) - coordinator.isNotAlive - delegate to next defender")
    defender.isAlive()
  }

  override def hasNextAttack(): Boolean = {
    if(coordinator.hasNextAttack()) {
      Log.debug(this, " (hasNextAttack) - coordinator.hasNextAttack")
      return true
    }
    Log.debug(this, " (hasNextAttack) - coordinator.hasNotNextAttack - delegate to next defender")
    if(coordinator.isAlive()){
      return false
    }
    defender.hasNextAttack()
  }
}
