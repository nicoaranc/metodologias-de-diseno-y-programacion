package cl.uchile.dcc.citric
package model.paneles
import model.PlayerCharacter
import model.Panel

import scala.collection.mutable.ArrayBuffer

abstract class home extends Panel{

  val characters: ArrayBuffer[PlayerCharacter]

  var nextPanels: ArrayBuffer[Panel]

  def addCharacter(player: PlayerCharacter): Unit = {
    characters.addOne(player)
  }

  def removeCharacter(player: PlayerCharacter): Unit = {
    characters.remove(player)
  }

  val owner: PlayerCharacter /** there is only one owner of the home panel */

  def end(player: PlayerCharacter): Unit = {
    if (player == owner){
      /** the player can choose between stop in the panel or continues to other panel */
    }
  }

  def activate(): Unit = {

  }

}
