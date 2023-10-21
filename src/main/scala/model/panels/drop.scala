package cl.uchile.dcc.citric
package model.panels

import model.traits.Panel
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class drop extends Panel{

  /** "characters" is the ArrayBuffer of the players that are on the Panel */
  val characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()

  /** "nextPanels" is the ArrayBuffer of the panels that they are next in
   * every direction of the panel */
  var nextPanels: ArrayBuffer[Panel] = new ArrayBuffer[Panel]()


  def apply(player: PlayerCharacter): Unit = {
    val q: Int = player.rollDice() * player.norma_id
    if (q >= player.stars){
      player.stars = 0
    }
    else{
      player.stars -= q
    }
  }
}