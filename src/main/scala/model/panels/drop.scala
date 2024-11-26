package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.abstractclasses.AbsPanel
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** Represents a drop panel.
 *
 * A Drop Panel drops the player's stars.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */
class Drop extends AbsPanel{


  /** Drops the stars from the player.
   *
   * This might be invoked when a player moves to this panel.
   *
   * @param player The player that is on the panel.
   */
  def apply(player: PlayerCharacter): Unit = {
    val q: Int = player.rollDice() * player.norma_id
    if (q >= player.stars){
      player.stars_=( 0)
    }
    else{
      val a: Int = player.stars - q
      player.stars_=(a)
    }
  }
}