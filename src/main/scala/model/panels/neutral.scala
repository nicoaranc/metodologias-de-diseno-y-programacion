package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.abstractclasses.AbsPanel
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** Represents a neutral panel.
 *
 * A Neutral Panel doesn't have any effects to the players.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class neutral extends AbsPanel {


  /** this method doesn't make any kind of effect */
  def apply(p: PlayerCharacter): Unit = {

  }

}
