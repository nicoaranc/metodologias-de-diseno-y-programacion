package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.abstractclasses.Panel
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class home  extends Panel {

  /** "characters" is the ArrayBuffer of the players that are on the Panel */
  val characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()

  /** "nextPanels" is the ArrayBuffer of the panels that they are next in
   * every direction of the panel */
  var nextPanels: ArrayBuffer[Panel] = new ArrayBuffer[Panel]()




  /** the "stop" method of the class is the function that verifies if the current player over the panel is the
   * owner of the same panel, in the case it is, the owner can stop on the panel and activate it, but if the
   * player isn't the owner of the panel, the player must continues if it have more movements to do */

  def canStop(player: PlayerCharacter): Boolean = {
    if (player.panelOwned == this) {
      return true
    }
    else {
      return false
    }
  }

  /** the method of "norma_check" checks if the player reached the goal to increase the norma level */
  def apply(player: PlayerCharacter): Boolean = {
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




}
