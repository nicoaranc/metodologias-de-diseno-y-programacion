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




  /** the method of "norma_check" checks if the player reached the goal to increase the norma level */
  def apply(player: PlayerCharacter): Unit = {
    if (player.kind_goal == "stars"){
      if (player.stars >= player.goal){
        player.norma_Clear(this)
      }
    }
    else {
      if (player.victories >= player.goal){
        player.norma_Clear(this)
      }
    }
  }

}
