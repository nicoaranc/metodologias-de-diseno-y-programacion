package cl.uchile.dcc.citric
package model.states

import model.abstractclasses.AbstractState

class Chapter extends AbstractState{

  override def newChapter(): Unit = {
    context.chapters += 1;
  }

  override def playTurn(): Unit = {
    context.setState(new PlayerTurn())
  }

  override def normaSixReached(): Unit = {
    /** IMPLEMENTAR LUEGO DE IMPLEMENTAR EL OBSERVER PATTERN */
  }
}
