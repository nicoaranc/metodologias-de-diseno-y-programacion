package cl.uchile.dcc.citric
package model.states

import model.controller.Gamecontroller

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.GameState

class RecoveryPhase extends AbstractState {

  private var roll_to_leave: Int = 7 - context.chapters

  override def rollsDice(): Unit = {
    if (roll_to_leave <= 1){
      context.setState(new PlayerCanPlay())
    }
    else{
      val rollNumber: Int = context.currentPlayer.get.rollDice()
      if (rollNumber >= roll_to_leave){
        context.setState(new PlayerCanPlay())
      }
      else{
        context.setPlayer()
        context.setState(new Chapter())
      }
    }
  }
}
