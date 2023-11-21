package cl.uchile.dcc.citric
package model.states

import model.controller.Gamecontroller

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.GameState

class OppAlive extends AbstractState{

  override def checkHp(): Unit = {
    /** hp from the opponent
     * if (hp == 0){
     *    context.setState(new AppPanel())
     * }
     * else{
     *    context.setState(new DecFightPlayer())
     * }*/
  }

}
