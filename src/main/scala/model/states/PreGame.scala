package cl.uchile.dcc.citric
package model.states

import model.controller.Gamecontroller

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.GameState

class PreGame extends AbstractState {

  override def startGame(): Unit = {
    context.setState(new Chapter())
  }

}
