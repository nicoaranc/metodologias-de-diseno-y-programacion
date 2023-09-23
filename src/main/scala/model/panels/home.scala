package cl.uchile.dcc.citric
package model.panels

import model.traits.Panel
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class home (val owner: PlayerCharacter) extends Panel {

  /** "characters" is the ArrayBuffer of the players that are on the Panel */
  val characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()

  /** "nextPanels" is the ArrayBuffer of the panels that they are next in
   * every direction of the panel */
  var nextPanels: ArrayBuffer[Panel] = new ArrayBuffer[Panel]()

  /** the "addCharacter" method of the class add the player to the ArrayBuffer of the players on the panel
   * if the player is not in te Panel yet, but if the player already is on the Panel, the method don't do
   * anything */
  def addCharacter(player: PlayerCharacter): Unit = {
    if (characters.indexOf(player) == -1) {
      characters.addOne(player)
    }
  }

  /** the "removeCharacter" method of the class removes the player if it is on the ArrayBuffer of the players
   * on the Panel, but if the player is not on the Panel, the method don't do anything */
  def removeCharacter(player: PlayerCharacter): Unit = {
    if (characters.indexOf(player) != -1) {
      val index: Int = characters.indexOf(player)
      characters.remove(index)
    }
  }

  /** the "stop" method of the class is the function that verifies if the current player over the panel is the
   * owner of the same panel, in the case it is, the owner can stop on the panel and activate it, but if the
   * player isn't the owner of the panel, the player must continues if it have more movements to do */
  def stop(player: PlayerCharacter): Boolean = {
    if (player == owner) {
      return true
    }
    else {
      return false
    }
  }

  /** the method of "norma_check" make the norma check of the player */
  /** def norma_check(player: PlayerCharacter): Boolean */

}
