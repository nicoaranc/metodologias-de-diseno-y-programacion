package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.{GameState, Units}


class PlayerTurn (context: GameController) extends AbstractState (context) {


  override def checkHp(): Unit = {
    context.turns += 1
    val HitPoints: Int = context.currentPlayer.get.Hp
    if (HitPoints == 0){
      context.setState(new RecoveryPhase(context))
    }
    else{
      context.setState(new PlayerCanPlay(context))
    }
  }

}
