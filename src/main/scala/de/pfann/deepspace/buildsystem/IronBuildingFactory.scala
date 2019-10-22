package de.pfann.deepspace.buildsystem

class IronBuildingFactory extends ResourceBuildingFactory {

  override def create(): ResourceBuilding = {
    new IronBuilding(100,1)
  }

}
