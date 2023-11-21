package cl.uchile.dcc.citric
package model.states

import model.controller.Gamecontroller

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.GameState

class OnAPanel extends AbstractState{

  override def checkPanel(): Unit = {
    /** if (panel vacío){
     *      context.setState(new ApplyPanel())
     *  }
     *  else{
     *      context.setState(new DecisionToFight())*/
  }

}
