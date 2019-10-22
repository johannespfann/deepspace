package de.pfann.deepspace.fightsystem.chain

import de.pfann.deepspace.api.{AttackAction, Fightable}


trait DefenderState {

  def isAlive(): Boolean

  def hasNextAttack(): Boolean

  def attack(aAttacker: AttackerState, attackAction: AttackAction): Unit

  def getFleets(): List[Fightable]

}
