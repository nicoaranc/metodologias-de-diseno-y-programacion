package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.GameState

/** Represents the PlayerCanPlay GameState.
 *
 * The PlayerCanPlay GameState is the state where the current
 * Player can start his turn
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */


class PlayerCanPlay (context: GameController) extends AbstractState (context){

  /** make the transition to the Movement state
   *
   * This function might be invoked when the GameController
   * wants to set the Movement state from the PlayerCanPlay state
   *
   * */
  override def starsForPlayer(): Unit = {
    context.setState(new Movement(context))
  }

}
