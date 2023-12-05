package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.GameState

/** Represents the RecoveryPhase GameState.
 *
 * The RecoveryPhase GameState is the state where the current player
 * tries to leave the RecoveryPhase and start the turn
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class RecoveryPhase (context: GameController) extends AbstractState (context){

  /** the player rolls a Dice, and then make the transition to the proper state
   *
   * This function might be invoked when the GameController
   * wants to make a transition from the RecoveryPhase state
   *
   * */
  override def rollsDice(): Unit = {
    if (context.currentPlayer.get.Recovery) {
      val roll_to_leave: Int = 6 - (context.chapters - context.currentPlayer.get.recoveryChapter)
      if (roll_to_leave <= 1){
        context.playerLeaveRecovery()
        context.setState(new PlayerCanPlay(context))
      }
      else{
        to_leave_recovery(roll_to_leave)
      }
    }
    else{
      val roll_to_leave: Int = 6
      to_leave_recovery(roll_to_leave)
    }
  }

  /** checks if the player can leave the RecoveryPhase
   *
   * This function might be invoked when the player
   * tries to leave the RecoveryPhase
   *
   * @param a The number to reach for leave the RecoveryPhase
   * */
  private def to_leave_recovery(a: Int): Unit = {
    val rollNumber: Int = context.currentPlayer.get.rollDice()
    if (rollNumber >= a) {
      context.playerLeaveRecovery()
      context.setState(new PlayerCanPlay(context))
    }
    else {
      if (!context.currentPlayer.get.Recovery){
        context.currentPlayer.get.Recovery_=(true)
        context.currentPlayer.get.recoveryChapter = context.chapters
      }
      context.setPlayer()
      context.setState(new Chapter(context))
    }
  }
}
