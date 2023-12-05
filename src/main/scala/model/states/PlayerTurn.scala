package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.{GameState, Units}


/** Represents the PlayerTurn GameState.
 *
 * The PlayerTurn GameState is the state where the game checks if
 * the current Player can directly go to his turn or make the
 * transition to the Recovery phase
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class PlayerTurn (context: GameController) extends AbstractState (context) {


  /** checks the current player's Hp, and then makes the transition
   *
   * This function might be invoked when the GameController
   * wants to make a transition from the PlayerTurn state
   *
   * */
  override def checkHp(): Unit = {
    context.newTurn()
    val HitPoints: Int = context.currentPlayer.get.Hp
    if (HitPoints == 0){
      context.setState(new RecoveryPhase(context))
    }
    else{
      context.setState(new PlayerCanPlay(context))
    }
  }

}
