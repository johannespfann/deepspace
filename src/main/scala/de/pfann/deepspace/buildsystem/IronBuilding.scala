package de.pfann.deepspace.buildsystem

class IronBuilding(val initResourcePerHour: Int, val aLevel: Int) extends ResourceBuilding {


  def getResourcePerHouer(): Int = {
    initResourcePerHour * aLevel
  }

  def getLevel(): Int = {
    aLevel
  }

  def updateLevel(): IronBuilding = {
    new IronBuilding(initResourcePerHour, aLevel + 1)
  }

}
