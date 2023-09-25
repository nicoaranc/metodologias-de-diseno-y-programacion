package cl.uchile.dcc.citric
package model.panels

import model.traits.Panel
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class home  extends Panel {

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

  /** the addPanel method adds a Panel to the list of nextPanels */
  def addPanel(panel: Panel): Unit = {
    if (nextPanels.indexOf(panel) == -1) {
      nextPanels.addOne(panel)
    }
  }

  /** the "stop" method of the class is the function that verifies if the current player over the panel is the
   * owner of the same panel, in the case it is, the owner can stop on the panel and activate it, but if the
   * player isn't the owner of the panel, the player must continues if it have more movements to do
  def canStop(player: PlayerCharacter): Boolean = {
    if (player == owner) {
      return true
    }
    else {
      return false
    }
  }
   */

  /** the method of "norma_check" checks if the player reached the goal to increase the norma level
  def norma_check(player: PlayerCharacter): Boolean = {
    if (player.kind_goal == "stars"){
      if (player.stars >= player.goal){
        return true
      }
      else{
        return false
      }
    }
    else {
      if (player.victories >= player.goal){
        return true
      }
      else{
        return false
      }
    }
  }
  */

  /** norma_Clear checks if the player already done the norma_check
   * with positive results, increases his norma level
  def norma_Clear(player: PlayerCharacter): Unit = {
    val a: Int = player.norma_id
    if (norma_check(player)){
      player.norma = player.NormaArray(a)
      player.norma_id += 1
    }
  }
  */

}
