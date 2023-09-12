package cl.uchile.dcc.citric
package model.paneles
import model.PlayerCharacter
import model.Panel

import scala.collection.mutable.ArrayBuffer

class bonus extends Panel{

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

  /** the "give_stars" method of the class gives the minimum quantity of stars between roll*norma or roll*3 to
   * the player */
  def give_stars(player: PlayerCharacter): Unit = {
    val roll: Int = player.rollDice()
    val Norm: Int = player.norma
    val a = roll * Norm
    val b = roll * 3
    if (a <= b){
      player.stars += a
    }
    else{
      player.stars += b
    }
  }
}
