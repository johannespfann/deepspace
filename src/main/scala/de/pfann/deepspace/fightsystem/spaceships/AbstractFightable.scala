package de.pfann.deepspace.fightsystem.spaceships

import de.pfann.deepspace.api.{AttackAction, Fightable}

abstract class AbstractFightable(lifePoints: Int, shildPoints: Int) extends Fightable {


  override def attacke(attackAction: AttackAction): Fightable = {
    val demage = attackAction.getDemage();

    val newShildValue = shildPoints - demage;

    if(newShildValue >= 0) {
      return copyFightable(lifePoints,newShildValue)
    }

    val newLifeValue = lifePoints + shildPoints;

    val restLife = newLifeValue - demage

    if(restLife > 0) {
      return copyFightable(restLife,0)
    }

    println(this.getClass.getSimpleName + " (attack) fleet is DEAD")
    copyFightable(0,0)
  }


  override def getLifePoints(): Int = lifePoints

  override def getShildPoints(): Int = shildPoints
}
