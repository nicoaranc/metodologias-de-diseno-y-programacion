package cl.uchile.dcc.citric
package model.states

import model.abstractclasses.AbstractState

import cl.uchile.dcc.citric.model.controller.GameController
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.Units

/** Represents the PlayerAttacks GameState.
 *
 * The PlayerAttacks GameState is the state where the current
 * Player already done his attack to the current Rival
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class PlayerAttacks (context: GameController) extends AbstractState (context){

  /** checks the current Rival's Hp, and then make the transition
   *
   * This function might be invoked when the GameController
   * wants to make a transition from the PlayerAttacks State
   *
   * */
  override def checkHp(): Unit = {
    val rival: PlayerCharacter = context.currentRival.get
    if (rival.Hp == 0){
      context.setState(new AppPanel(context))
    }
    else{
      val player: PlayerCharacter = context.currentPlayer.get
      rival.attacking_to(player)
      context.setState(new OpponentAttacks(context))
    }
  }

}
