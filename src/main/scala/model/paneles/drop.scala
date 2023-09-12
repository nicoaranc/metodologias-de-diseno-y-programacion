package cl.uchile.dcc.citric
package model.paneles
import model.PlayerCharacter
import model.Panel

import scala.collection.mutable.ArrayBuffer

class drop (val id: Int) extends Panel{

  val characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()

  var nextPanels: ArrayBuffer[Panel] = new ArrayBuffer[Panel]()

  def addCharacter(player: PlayerCharacter): Unit = {
    if (characters.indexOf(player) == -1) {
      characters.addOne(player)
    }
  }

  def removeCharacter(player: PlayerCharacter): Unit = {
    if (characters.indexOf(player) != -1) {
      val index: Int = characters.indexOf(player)
      characters.remove(index)
    }
  }
}