package de.pfann.deepspace.fightsystem.chain

import de.pfann.deepspace.api.{AttackAction, Fightable}

trait AttackerState {

  def startFight(): Unit

  def getFleets(): List[Fightable]

  def attack(attackAction: AttackAction): Unit

  def isAlive(): Boolean


}
