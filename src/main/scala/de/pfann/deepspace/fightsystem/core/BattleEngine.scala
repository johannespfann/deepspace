package de.pfann.deepspace.fightsystem.core

import de.pfann.deepspace.api.Fightable


class BattleEngine(teamA: List[Fightable], teamB: List[Fightable]) {

  def start(): Unit = {
    val newRound = new BattleRound()

    var contitionA = true
    var contitionB = true
    var battleFleets = new BattleFleets(teamA, teamB)



    while(contitionA && contitionB) {

      println("##################[Start new Round with]#######################")
      println("")
      println("")

      battleFleets = newRound.startRound(battleFleets)
      contitionA = battleFleets.getAttackerFleet().exists( fleet => fleet.getLifePoints() > 0 )
      contitionB = battleFleets.getDefenderFleet().exists( fleet => fleet.getLifePoints() > 0 )

    }



    }


}
