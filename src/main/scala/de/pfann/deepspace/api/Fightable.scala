package de.pfann.deepspace.api

trait Fightable {

  def getAttackAction(): AttackAction;

  def attacke(attackAction: AttackAction): Fightable;

  def copyFightable(lifePoints: Int, shildPoints: Int): Fightable

  def getLifePoints(): Int

  def getShildPoints(): Int

}
