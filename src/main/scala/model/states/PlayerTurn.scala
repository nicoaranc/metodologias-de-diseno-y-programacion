package cl.uchile.dcc.citric
package model.states

import model.controller.Gamecontroller

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.GameState


class PlayerTurn extends AbstractState {


  override def checkHp(): Unit = {
    val HitPoints: Int = context.currentPlayer.get.Hp
    if (HitPoints == 0){
      context.setState(new RecoveryPhase())
    }
    else{
      context.setState(new PlayerCanPlay())
    }
  }

}
