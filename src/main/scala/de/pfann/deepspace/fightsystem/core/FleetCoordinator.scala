package de.pfann.deepspace.fightsystem.core

import de.pfann.deepspace.api.{AttackAction, FieldCoordinator, Fightable}
import de.pfann.deepspace.fightsystem.runtime.{AttackAction, FieldCoordinator}


class FleetCoordinator(fleets: List[Fightable]) extends FieldCoordinator{


  var attackIndex: Int = -1
  val arrayFleets = fleets.toArray


  override def attackFleet(attackAction: AttackAction): Unit = {
    val indexesOfAliveFleets = getIndexesOfAliveFleets()

    val randomIndex = getRandomIndex(indexesOfAliveFleets)

    val fleet = arrayFleets.apply(randomIndex)
    val newFleet = fleet.attacke(attackAction)

    arrayFleets.update(randomIndex, newFleet)
  }

  override def getNextAttack(): AttackAction = {
    attackIndex = attackIndex + 1

    val fleet = arrayFleets.apply(attackIndex)

    if(fleet.getLifePoints() > 0) {
      return fleet.getAttackAction()
    }

    getNextAttack()
  }

  override def isAlive(): Boolean = {
    arrayFleets.exists( x => x.getLifePoints() > 0)
  }

  override def hasNextAttack(): Boolean = {
    var tempIndex = attackIndex

    if(fleets.isEmpty){
      return false
    }

    tempIndex = tempIndex + 1

    while(tempIndex < fleets.length) {
      if(arrayFleets.apply(tempIndex).getLifePoints() > 0) {
        return true
      }
      tempIndex = tempIndex + 1
    }

    false
  }

  override def getCurrentFleet(): List[Fightable] = {
    List.from(arrayFleets);
  }

  private def getRandomIndex(indexesOfAliveFleets: List[Int]): Int = {
    indexesOfAliveFleets.apply(0)
  }

  private def getIndexesOfAliveFleets(): List[Int] = {
    var indexesOfAliveFleets = List[Int]()

    if(fleets.isEmpty) {
      return indexesOfAliveFleets
    }

    var index = 0
    while(index < arrayFleets.length) {
      val fleet = arrayFleets.apply(index)

      if(fleet.getLifePoints() > 0) {
        indexesOfAliveFleets ::= index
      }

      index = index + 1
    }

    indexesOfAliveFleets
  }

}
