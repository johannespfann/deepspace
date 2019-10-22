package de.pfann.deepspace.resourcesystem

import java.time.LocalDateTime

trait Resource {

  def getLastModified(): LocalDateTime
  def getResource(): Int

}
