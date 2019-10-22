package de.pfann.deepspace.fightsystem.core

import de.pfann.deepspace.api.Fightable
import de.pfann.deepspace.fightsystem.chain.{AttackerBattleFieldState, AttackerEndState, DefenderBattleFieldState, DefenderEndState}
import de.pfann.deepspace.fightsystem.spaceships.{CloseCombat, LongRangedAttack, RangedAttack}

class BattleRound() {

  def startRound(party: BattleFleets): BattleFleets = {

    println("#####[First Round]#############################################")

    val attackerBackgroundFleets = getRangedAttackFleets(party.getAttackerFleet())
    val attackerFrontFleets = getCloseCompatFleets(party.getAttackerFleet())

    val defenderFrontFleets = getCloseCompatFleets(party.getDefenderFleet())
    val defenderBackgroundFleets = getRangedAttackFleets(party.getDefenderFleet())
    val defenderStations = getDefenderRangedAttackFleets(party.getDefenderFleet())

    val attackerBackgroundCoordinator1 = new FleetCoordinator(attackerBackgroundFleets)
    val attackerFrontCoordinator1 = new FleetCoordinator(attackerFrontFleets)

    val defenderFrontCoordinator1 = new FleetCoordinator(defenderFrontFleets)
    val defenderBackgroundCoordinator1 = new FleetCoordinator(defenderBackgroundFleets)
    val defenderStationsBackgroundCoordinator1 = new FleetCoordinator(defenderStations)

    /**
      * first round
      */

    showFleets(attackerBackgroundCoordinator1, attackerFrontCoordinator1, defenderFrontCoordinator1, defenderBackgroundCoordinator1, defenderStationsBackgroundCoordinator1)

    println("#####[First Round]#############################################")
    val attackerEndState = new AttackerEndState();

    val defenderEndBattleState = new DefenderEndState()
    val defenderStationState = new DefenderBattleFieldState(defenderEndBattleState, defenderStationsBackgroundCoordinator1)
    val defenderBackgroundState = new DefenderBattleFieldState(defenderStationState, defenderBackgroundCoordinator1)
    val attackerBackgroundBattleSate = new AttackerBattleFieldState(attackerEndState, defenderBackgroundState, attackerBackgroundCoordinator1)
    attackerBackgroundBattleSate.startFight()

    /**
      * second round
      */

    println("#####[Second Round]#############################################")

    val attackerBackgroundCoordinator2 = new FleetCoordinator(attackerBackgroundCoordinator1.getCurrentFleet())
    val attackerFrontCoordinator2 = new FleetCoordinator(attackerFrontCoordinator1.getCurrentFleet())

    val defenderFrontCoordinator2 = new FleetCoordinator((defenderFrontCoordinator1.getCurrentFleet()))
    val defenderBackgroundCoordinator2 = new FleetCoordinator(defenderBackgroundCoordinator1.getCurrentFleet())
    val defenderStationCoordinator2 = new FleetCoordinator(defenderStationsBackgroundCoordinator1.getCurrentFleet())

    val defenderEndBattleState2 = new DefenderEndState()
    val defenderStationState2 = new DefenderBattleFieldState(defenderEndBattleState2, defenderStationCoordinator2)
    val defenderBackgroundState2 = new DefenderBattleFieldState(defenderStationState2, defenderBackgroundCoordinator2)
    val defenderFrontState2 = new DefenderBattleFieldState(defenderBackgroundState2, defenderFrontCoordinator2)

    val attackerEndState2 = new AttackerEndState()
    val attackerBackgroundSate2 = new AttackerBattleFieldState(attackerEndState2, defenderFrontState2, attackerBackgroundCoordinator2 )
    val attackerFrontState2 = new AttackerBattleFieldState(attackerBackgroundSate2, defenderFrontState2, attackerFrontCoordinator2)
    attackerFrontState2.startFight()

    println("#####[Result]####################################################")

    showFleets(attackerBackgroundCoordinator2, attackerFrontCoordinator2, defenderFrontCoordinator2, defenderBackgroundCoordinator2, defenderStationCoordinator2)

    val collectedAttackerFleets = List.concat(attackerFrontCoordinator2.getCurrentFleet(), attackerBackgroundCoordinator2.getCurrentFleet())
    val collectedDefenderFleets = List.concat(defenderStationCoordinator2.getCurrentFleet(), defenderBackgroundCoordinator2.getCurrentFleet(), defenderFrontCoordinator2.getCurrentFleet())
    new BattleFleets(collectedAttackerFleets, collectedDefenderFleets)
  }


  private def showFleets(attackerBackgroundCoordinator: FleetCoordinator, attackerFrontCoordinator: FleetCoordinator, defenderFrontCoordinator: FleetCoordinator, defenderBackgroundCoordinator: FleetCoordinator, defenderStationsBackgroundCoordinator: FleetCoordinator) = {
    println(" [Attackers fleet] ")
    println(attackerFrontCoordinator.getCurrentFleet())
    println(attackerBackgroundCoordinator.getCurrentFleet())

    println(" [Defenders fleet] ")
    println(defenderFrontCoordinator.getCurrentFleet())
    println(defenderBackgroundCoordinator.getCurrentFleet())
    println(defenderStationsBackgroundCoordinator.getCurrentFleet())
  }

  def getCloseCompatFleets(fleets: List[Fightable]): List[Fightable] = {
    fleets.filter(fleet => fleet.isInstanceOf[CloseCombat])
  }

  def getRangedAttackFleets(fleets: List[Fightable]): List[Fightable] = {
    fleets.filter(fleet => fleet.isInstanceOf[RangedAttack])
  }

  def getDefenderRangedAttackFleets(fleets: List[Fightable]): List[Fightable] = {
    fleets.filter(fleet => fleet.isInstanceOf[LongRangedAttack])
  }
}
