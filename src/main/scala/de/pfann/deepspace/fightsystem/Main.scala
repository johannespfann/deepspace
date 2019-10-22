package de.pfann.deepspace.fightsystem

import de.pfann.deepspace.api.{Cougar, Fightable, Schakal, SpaceStation}
import de.pfann.deepspace.fightsystem.core.BattleEngine
import de.pfann.deepspace.log.Log

object Main {

  def main(args: Array[String]): Unit = {


    /**
      * Team A
      */

    Log.isDebugOn(true)

    var teamA = List[Fightable]()

    teamA ::=  new Cougar(20,50,40)
    teamA ::=  new Cougar(20,50,40)
    teamA ::=  new Cougar(20,50,40)
    teamA ::=  new Cougar(20,50,40)
    teamA ::=  new Cougar(20,50,40)
    teamA ::=  new Cougar(20,50,40)
    teamA ::=  new Cougar(20,50,40)
    teamA ::=  new Cougar(20,50,40)
    teamA ::=  new Cougar(20,50,40)


    teamA ::=  new Schakal(4,50,60)
    teamA ::=  new Schakal(4,50,60)
    teamA ::=  new Schakal(4,50,60)
    teamA ::=  new Schakal(4,50,60)
    teamA ::=  new Schakal(4,50,60)
    teamA ::=  new Schakal(4,50,60)
    teamA ::=  new Schakal(4,50,60)
    teamA ::=  new Schakal(4,50,60)



    /**
      * Team B
      */

    var teamB = List[Fightable]()
    teamB ::= new Cougar(20,50,30)
    teamB ::= new Cougar(20,50,30)
    teamB ::= new Cougar(20,50,30)
    teamB ::= new Cougar(20,50,30)
    teamB ::= new Cougar(20,50,30)
    teamB ::= new Cougar(20,50,30)
    teamB ::= new Cougar(20,50,30)


    teamB ::= new Schakal(5,50,20)
    teamB ::= new Schakal(5,50,20)
    teamB ::= new Schakal(5,50,20)
    teamB ::= new Schakal(5,50,20)
    teamB ::= new Schakal(5,50,20)
    teamB ::= new Schakal(5,50,20)
    teamB ::= new Schakal(5,50,20)
    teamB ::= new Schakal(5,50,20)
    teamB ::= new Schakal(5,50,20)


    teamB ::=  new SpaceStation(30,50,20)
    teamB ::=  new SpaceStation(30,50,20)

    val battleEngine = new BattleEngine(teamA,teamB);
    battleEngine.start()
  }

}
