package de.pfann.deepspace.resourcesystem
import java.time.LocalDateTime

class Iron(private val resource: Int, private val lastModified: LocalDateTime) extends Resource {

  override def getLastModified(): LocalDateTime = {
    lastModified
  }

  override def getResource(): Int = {
    resource
  }

}
