package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.GameState

import scala.util.Random

/** Represents the DecisionToFight GameState.
 *
 * The DecisionToFight GameState is the state where the current
 * player have to decide between fight against another Player on the
 * same Panel or directly receive the panel's effect
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class DecisionToFight (context: GameController) extends AbstractState (context) {

  /** The player take the decision, and transition to the proper state
   *
   * This function might be invoked when the GameController
   * wants to make a transition from teh DecisionToFight state
   * (to AppPanel state or PlayerAttacks)
   *
   * */
  override def fight_decision(): Unit = {
    val roll: Int = new Random().nextInt(2) + 1
    if (roll == 1){
      context.setState(new AppPanel(context))
    }
    else{
      val player: PlayerCharacter = context.currentPlayer.get
      context.setRival()
      val rival: PlayerCharacter = context.currentRival.get
      player.attacking_to(rival)
      context.setState(new PlayerAttacks(context))
    }
  }

}
