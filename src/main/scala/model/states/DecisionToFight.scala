package cl.uchile.dcc.citric
package model.states

import model.controller.Gamecontroller

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.GameState

class DecisionToFight extends AbstractState {

  override def fight_decision(input: String): Unit = {
    if (input == "NO"){
      context.setState(new AppPanel())
    }
    else{
      context.setState(new DecFightOpp())
    }
  }

}
