package cl.uchile.dcc.citric
package model.states

import model.controller.Gamecontroller

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.GameState

class DecisionToFight extends AbstractState {

  override def fight_decision(input: String): Unit = {
    if (input == "NO"){
      context.setState(new AppPanel())
    }
    else{
      val player: PlayerCharacter = context.currentPlayer.get
      val rival: PlayerCharacter = context.currentRival.get
      player.attacking_to(rival)
      context.setState(new PlayerAttacks())
    }
  }

}
