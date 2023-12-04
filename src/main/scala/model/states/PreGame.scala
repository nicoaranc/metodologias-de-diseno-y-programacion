package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.GameState

class PreGame(context: GameController) extends AbstractState(context) {

  override def startGame(): Unit = {
    context.setState(new Chapter(context))
  }

}
