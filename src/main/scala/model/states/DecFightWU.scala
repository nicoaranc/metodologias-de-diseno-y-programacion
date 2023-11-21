package cl.uchile.dcc.citric
package model.states

import model.controller.Gamecontroller

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.GameState

class DecFightWU extends AbstractState {

  override def fight_decision(): Unit = {
    /** context.currentPlayer.get.attacking_to(Unit) */
    context.setState(new WUAlive())
  }

}
