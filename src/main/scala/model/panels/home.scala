package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.abstractclasses.AbsPanel
import cl.uchile.dcc.citric.model.events.NormaSixEvent
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.Norma

import scala.collection.mutable.ArrayBuffer

/** Represents a home panel.
 *
 * A Home Panel makes the NormaCheck effect to the players.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class Home  extends AbsPanel {

  /** Makes the Norma Check, and if it's possible the Norma Clear.
   *
   * This might be invoked when a player moves to this panel.
   *
   * @param player The player that is on the panel.
   */
  def apply(player: PlayerCharacter): Unit = {
    if (player.kind_goal == "stars"){
      if (player.stars >= player.goal){
        increase_norma(player)
      }
    }
    else {
      if (player.victories >= player.goal){
        increase_norma(player)
      }
    }
  }

  private def increase_norma(player: PlayerCharacter): Unit = {
    val a: Int = player.norma_id
    player.norma_=(player.NormaArray(a))
    player.norma_id_=(a + 1)
    val level: Norma = player.norma
    if (level.normaSix()) {
      player.notifyObservers(new NormaSixEvent())
    }
  }

}
