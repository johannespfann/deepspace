package de.pfann.deepspace.api

trait FieldCoordinator {

  def attackFleet(attackAction: AttackAction): Unit

  def isAlive(): Boolean

  def getNextAttack(): AttackAction

  def hasNextAttack(): Boolean

  def getCurrentFleet(): List[Fightable]
}
