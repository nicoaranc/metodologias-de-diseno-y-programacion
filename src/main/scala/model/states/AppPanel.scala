package cl.uchile.dcc.citric
package model.states

import model.abstractclasses.AbstractState

import cl.uchile.dcc.citric.model.controller.GameController
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.Panel

/** Represents the AppPanel GameState.
 *
 * The AppPanel GameState is the state where the current
 * Panel do their respective effect
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class AppPanel (context: GameController) extends AbstractState (context){

  /** The current Panel applies the effect to the current Player
   *
   * This function might be invoked when the GameController
   * wants to set the Chapter State from the AppPanel State
   *
   * */
  override def doEffect(): Unit = {
    val panel: Panel = context.currentPanel.get
    val player: PlayerCharacter = context.currentPlayer.get
    panel.apply(player)
    context.setPlayer()
    context.setState(new Chapter(context))
  }



}
