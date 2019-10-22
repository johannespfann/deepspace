package de.pfann.deepspace.api

import de.pfann.deepspace.fightsystem.core.SimpleAttackAction
import de.pfann.deepspace.fightsystem.spaceships.LongRangedAttack


class SpaceStation(aLifePoints: Int, aShildPoints: Int, aAttackPoints: Int) extends LongRangedAttack(aLifePoints,aShildPoints) {

  override def getAttackAction(): AttackAction = {
    new SimpleAttackAction(aAttackPoints)
  }

  override def copyFightable(lifePoints: Int, shildPoints: Int): Fightable = {
    new SpaceStation(lifePoints,shildPoints,aAttackPoints)
  }

  override def toString: String = {
    "SpaceStation(" + this.aLifePoints + " - " + this.aShildPoints + ")"
  }

}
