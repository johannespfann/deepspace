package de.pfann.deepspace.fightsystem.chain
import de.pfann.deepspace.api.{AttackAction, Fightable}


class AttackerEndState extends AttackerState{
  override def startFight(): Unit = {
    throw new NotImplementedError()
  }

  override def getFleets(): List[Fightable] = {
    List[Fightable]()
  }

  override def attack(attackAction: AttackAction): Unit = {
    println(this.getClass.getSimpleName + " attack - 0 -> should not happen")
    // do nothing
  }

  override def isAlive(): Boolean = {
    println(this.getClass.getSimpleName + " isAlive - false")
    false
  }
}
