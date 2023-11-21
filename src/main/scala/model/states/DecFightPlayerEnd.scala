package cl.uchile.dcc.citric
package model.states

import model.controller.Gamecontroller

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.GameState

class DecFightPlayerEnd extends AbstractState {

  override def fight_decision(): Unit = {
    val player : PlayerCharacter = context.currentPlayer.get
    /** WU attack_to_playChar(player) */
    context.setPlayer()
    context.setState(new PlayerTurn())
  }

}
