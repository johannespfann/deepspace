package de.pfann.deepspace.fightsystem.core

import de.pfann.deepspace.api.Fightable

class BattleFleets(val attacker: List[Fightable], val defender: List[Fightable]) {

  def getAttackerFleet(): List[Fightable] = {
    attacker
  }

  def getDefenderFleet(): List[Fightable] = {
    defender
  }

}
