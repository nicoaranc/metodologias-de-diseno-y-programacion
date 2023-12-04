package cl.uchile.dcc.citric
package model.states

import model.abstractclasses.AbstractState

import cl.uchile.dcc.citric.model.controller.GameController

class Chapter (context: GameController) extends AbstractState (context){

  override def newChapter(): Unit = {
    if (context.turns == 4){
      context.chapters += 1
      context.turns = 0
    }

  }

  override def playTurn(): Unit = {
    context.setState(new PlayerTurn(context))
  }

  override def normaSixReached(): Unit = {
    /** IMPLEMENTAR LUEGO DE IMPLEMENTAR EL OBSERVER PATTERN */
    context.setState(new EndGame(context))
  }
}
