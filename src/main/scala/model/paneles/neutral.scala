package cl.uchile.dcc.citric
package model.paneles

import model.PlayerCharacter
import model.Panel

import scala.collection.mutable.ArrayBuffer

abstract class neutral extends Panel {

  val characters: ArrayBuffer[PlayerCharacter]

  var nextPanels: ArrayBuffer[Panel]

  def addCharacter(player: PlayerCharacter): Unit = {
    characters.addOne(player)
  }

  def removeCharacter(player: PlayerCharacter): Boolean = {
    characters.remove(player)
  }
}
