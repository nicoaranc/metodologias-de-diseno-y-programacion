package cl.uchile.dcc.citric
package model.states

import model.controller.Gamecontroller

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.GameState

class DecisionToFight extends AbstractState {

  override def fight_decision(): Unit = {
    /** el player decide si atacar o no
     * If(decide no atacar){
     *    context.setState(new AppPanel())
     * }
     * else{
     *    context.setState(new DecFightOpp())
     * }*/
  }

}
