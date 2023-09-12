package cl.uchile.dcc.citric
package model.paneles
import model.PlayerCharacter
import model.Panel

import scala.collection.mutable.ArrayBuffer

class bonus extends Panel{

  val characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()

  var nextPanels: ArrayBuffer[Panel] = new ArrayBuffer[Panel]()

  def addCharacter(player: PlayerCharacter): Unit = {
    characters.addOne(player)
  }

  def removeCharacter(player: PlayerCharacter): Unit = {
    val index: Int = characters.indexOf(player)
    characters.remove(index)
  }
}
