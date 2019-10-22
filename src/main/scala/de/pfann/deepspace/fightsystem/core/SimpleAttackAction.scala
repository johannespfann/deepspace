package de.pfann.deepspace.fightsystem.core

import de.pfann.deepspace.api.AttackAction

class SimpleAttackAction(val aDamage: Int) extends AttackAction {

  override def getDemage(): Int = {
    aDamage
  }

}
