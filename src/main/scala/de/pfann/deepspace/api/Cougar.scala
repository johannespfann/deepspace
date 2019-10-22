package de.pfann.deepspace.api

import de.pfann.deepspace.fightsystem.core.SimpleAttackAction
import de.pfann.deepspace.fightsystem.spaceships.RangedAttack

class Cougar(aLifePoints: Int, aShildPoints: Int, aAttackPoints: Int) extends RangedAttack(aLifePoints, aShildPoints)
  with Airworthy {

  override def toString: String = {
    "Cougar(" + aLifePoints + " - " + aShildPoints + ")"
  }

  override def getVelocity(): Int = {
    1
  }

  override def getFuel(): Int = {
    2
  }

  override def getAttackAction(): AttackAction = {
    new SimpleAttackAction(aAttackPoints)
  }

  override def copyFightable(lifePoints: Int, shildPoints: Int): Fightable = {
    new Cougar(lifePoints, shildPoints, aAttackPoints)
  }

}
