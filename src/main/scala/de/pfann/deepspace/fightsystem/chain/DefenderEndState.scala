package de.pfann.deepspace.fightsystem.chain
import de.pfann.deepspace.api.{AttackAction, Fightable}

class DefenderEndState extends DefenderState {

  override def attack(aAttacker: AttackerState, attackAction: AttackAction): Unit = {
    println(this.getClass.getName + " attack - 0 -> should not happen")
  }

  override def getFleets(): List[Fightable] = {
    List[Fightable]()
  }

  override def isAlive(): Boolean = {
    println(this.getClass.getSimpleName + " isAlive - false")
    false
  }

  override def hasNextAttack(): Boolean = {
    println(this.getClass.getSimpleName + " hashNextAttack - false")
    false
  }
}
