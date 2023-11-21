package cl.uchile.dcc.citric
package model.states

import model.controller.Gamecontroller

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.GameState

class Movement extends AbstractState{

  override def rollsDice(): Unit = {
    val number: Int = context.currentPlayer.get.rollDice()
    var a = 0

    for (a <- 1 to number){
      /** Choose path*/
    }

    context.setState(new OnAPanel())

  }

}
