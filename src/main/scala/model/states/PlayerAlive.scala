package cl.uchile.dcc.citric
package model.states

import model.controller.Gamecontroller

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.GameState

class PlayerAlive extends AbstractState{

  override def checkHp(): Unit = {
    val player: PlayerCharacter = context.currentPlayer.get
    if (player.Hp == 0){
      context.setPlayer()
      context.setState(new PlayerTurn())
    }
    else{
      context.setState(new AppPanel())
    }
  }

}
