package de.pfann.deepspace.fightsystem

import de.pfann.deepspace.api.{Cougar, Fightable, SpaceStation}
import de.pfann.deepspace.fightsystem.core.{FleetCoordinator, SimpleAttackAction}
import org.scalatest.FlatSpec

class CoordinatorTest extends FlatSpec{

  "FleetCoordinator" should(" have no attacks with no fleets") in  {
    // prepare
    val attackerBackgroundCoordinator = new FleetCoordinator(List[Fightable]())
    // validate and execute
    assert(attackerBackgroundCoordinator.hasNextAttack() == false)

  }

  "FleetCoordinator" should(" have one attacks with on fleet") in  {

    var teamB = List[Fightable]()
    teamB ::= new Cougar(20,50,10)

    val attackerBackgroundCoordinator = new FleetCoordinator(teamB)
    assert(attackerBackgroundCoordinator.hasNextAttack() == true)
  }


  "FleetCoordinator" should(" say two times hasNext with two ships") in  {
    // prepare
    var teamB = List[Fightable]()
    teamB ::= new Cougar(20,50,10)
    teamB ::= new Cougar(20,50,10)
    val attackerBackgroundCoordinator = new FleetCoordinator(teamB)

    // execute
    val firstTime = attackerBackgroundCoordinator.hasNextAttack()
    attackerBackgroundCoordinator.getNextAttack()
    val secondTime = attackerBackgroundCoordinator.hasNextAttack()
    attackerBackgroundCoordinator.getNextAttack()
    val thirdTime = attackerBackgroundCoordinator.hasNextAttack()

    // validate
    assert(firstTime == true)
    assert(secondTime == true)
    assert(thirdTime == false)
  }

  "FleetCoordinator" should("return one time hashNext") in {
    var teamB = List[Fightable]()
    teamB ::= new Cougar(0,0,10)
    teamB ::= new Cougar(20,50,10)
    teamB ::= new Cougar(0,50,10)
    teamB ::= new Cougar(0,0,10)
    val attackerBackgroundCoordinator = new FleetCoordinator(teamB)

    // execute
    println(" ### first try")
    val firstTry = attackerBackgroundCoordinator.hasNextAttack();
    println(" ### getNextAttack")
    attackerBackgroundCoordinator.getNextAttack()
    println(" ### second try")
    val secondTry = attackerBackgroundCoordinator.hasNextAttack();

    // validate
    assert(firstTry == true)
    assert(secondTry == false)
  }

  "FleetCoordinator" should(" attack one alive fleet") in {
    // prepare
    var teamB = List[Fightable]()
    teamB ::= new Cougar(0,0,10)
    teamB ::= new Cougar(0,0,10)
    teamB ::= new Cougar(20,10,10)
    teamB ::= new Cougar(0,0,10)
    val attackerBackgroundCoordinator = new FleetCoordinator(teamB)

    val attackAction = new SimpleAttackAction(20)

    // execute
    attackerBackgroundCoordinator.attackFleet(attackAction)
    val newFleets = attackerBackgroundCoordinator.getCurrentFleet()

    // validate
    val foundFleets = newFleets.find( fleet => fleet.getLifePoints() > 0)

    assert(foundFleets.get.getLifePoints() == 10)
    assert(foundFleets.get.getShildPoints() == 0)
  }

  "FleetCoordinator" should(" attack one alive fleet2") in {
    // prepare
    var teamB = List[Fightable]()
    teamB ::= new SpaceStation(10,10,10)
    val attackerBackgroundCoordinator = new FleetCoordinator(teamB)

    val attackAction = new SimpleAttackAction(20)

    // execute

    val firstTry = attackerBackgroundCoordinator.hasNextAttack()

    attackerBackgroundCoordinator.attackFleet(attackAction)

    val secondTry = attackerBackgroundCoordinator.hasNextAttack()

    // validate
    assert(firstTry == true)
    assert(secondTry == false)
  }



}
