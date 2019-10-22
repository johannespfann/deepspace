package de.pfann.deepspace.api

import de.pfann.deepspace.fightsystem.core.SimpleAttackAction
import de.pfann.deepspace.fightsystem.spaceships.CloseCombat


class Schakal(aLifePoints: Int, aShildPoints: Int, aAttackPoints: Int) extends CloseCombat(aLifePoints,aShildPoints)
  with Airworthy {

  override def toString: String = {
    "Schakal(" + this.aLifePoints + " - " + this.aShildPoints + ")"
  }

  override def getVelocity(): Int = {
    2
  }

  override def getFuel(): Int = {
    2
  }

  override def getAttackAction(): AttackAction = {
    new SimpleAttackAction(aAttackPoints)
  }

  override def copyFightable(lifePoints: Int, shildPoints: Int): Fightable = {
    new Schakal(lifePoints, shildPoints, aAttackPoints)
  }

}
