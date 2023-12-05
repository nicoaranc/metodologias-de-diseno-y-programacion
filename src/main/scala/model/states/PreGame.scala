package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.GameState

/** Represents the PreGame GameState.
 *
 * The PreGame GameState is the initial state
 * of the game
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class PreGame(context: GameController) extends AbstractState(context) {

  /** Starts the game
   *
   * This function might be invoked when the GameController
   * wants to start the game
   *
   * */
  override def startGame(): Unit = {
    context.setState(new Chapter(context))
  }


}
