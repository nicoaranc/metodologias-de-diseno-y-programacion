package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.GameState

class RecoveryPhase (context: GameController) extends AbstractState (context){

  override def rollsDice(): Unit = {
    if (context.currentPlayer.get.Recovery) {
      val roll_to_leave: Int = 7 - context.chapters
      if (roll_to_leave <= 1){
        context.currentPlayer.get.Recovery_=(false)
        context.setState(new PlayerCanPlay(context))
      }
      else{
        leave_recovery(roll_to_leave)
      }
    }
    else{
      val roll_to_leave: Int = 6
      leave_recovery(roll_to_leave)
    }
  }

  def leave_recovery(a: Int): Unit = {
    val rollNumber: Int = context.currentPlayer.get.rollDice()
    if (rollNumber >= a) {
      context.currentPlayer.get.Recovery_=(false)
      context.setState(new PlayerCanPlay(context))
    }
    else {
      context.currentPlayer.get.Recovery_=(true)
      context.setPlayer()
      context.setState(new Chapter(context))
    }
  }
}
