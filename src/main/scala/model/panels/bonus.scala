package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.abstractclasses.Panel
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class bonus extends Panel{

  /** "characters" is the ArrayBuffer of the players that are on the Panel */
  val characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()

  /** "nextPanels" is the ArrayBuffer of the panels that they are next in
   * every direction of the panel */
  var nextPanels: ArrayBuffer[Panel] = new ArrayBuffer[Panel]()

  /** gives stars to the player on the panel */
  def apply(player: PlayerCharacter): Unit = {
    val roll: Int = player.rollDice()
    val Norm: Int = player.norma_id
    val a = roll * Norm
    val b = roll * 3
    if (a <= b){
      val c: Int = player.stars + a
      player.stars_= (c)
    }
    else{
      val c: Int = player.stars + b
      player.stars_=(c)
    }
  }
}
