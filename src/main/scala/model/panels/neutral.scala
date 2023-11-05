package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.abstractclasses.Panel
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** Represents a neutral panel.
 *
 * A Neutral Panel doesn't have any effects to the players.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class neutral extends Panel {

  /** "characters" is the ArrayBuffer of the players that are on the Panel  */
  val characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()

  /** "nextPanels" is the ArrayBuffer of the panels that they are next in
   * every direction of the panel */
  var nextPanels: ArrayBuffer[Panel] = new ArrayBuffer[Panel]()

  /** this method doesn't make any kind of effect */
  def apply(): Unit = {

  }

}
