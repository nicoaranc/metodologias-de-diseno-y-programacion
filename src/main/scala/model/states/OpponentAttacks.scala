package cl.uchile.dcc.citric
package model.states

import model.abstractclasses.AbstractState

import cl.uchile.dcc.citric.model.controller.GameController
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.Units

/** Represents the OpponentAttacks GameState.
 *
 * The OpponentAttacks GameState is the state where the current
 * rival already done his attack to the current Player
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */


class OpponentAttacks (context: GameController) extends AbstractState (context){


  /** checks the current Player's Hp, and then make the transition
   *
   * This function might be invoked when the GameController
   * wants to make a transition from the OpponentAttacks State
   *
   * */
  override def checkHp(): Unit = {
    val player: PlayerCharacter = context.currentPlayer.get
    context.currentRival = None
    if (player.Hp == 0){
      context.setPlayer()
      context.setState(new Chapter(context))
    }
    else{
      context.setState(new AppPanel(context))
    }
  }

}
