package cl.uchile.dcc.citric
package model.states

import model.controller.Gamecontroller

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.GameState

class WUAlive extends AbstractState {

  override def checkHp(): Unit = {
    /** Hp from the wild unit
     * if (Hp == 0){
     *    context.setPlayer()
     *    context.setState(new PlayerTurn())
     * }
     * else{
     *    context.setState(new DecFightPlayerEnd())
     * }
     */
  }

}
