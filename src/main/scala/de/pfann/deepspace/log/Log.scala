package de.pfann.deepspace.log

object Log {

  var debugOn = true

  def isDebugOn(value: Boolean) : Unit = {
    debugOn = value
  }


  def debug(aClass: Object, aMessage: String) = {
    if(debugOn == true) {
      println("[" + aClass.getClass.getSimpleName + "]" + " - " + aMessage)
    }

  }

  def info(aClass: Object, aMessage: String): Unit = {
    println("[" + aClass.getClass.getSimpleName + "]" + " - " + aMessage)
  }

}
