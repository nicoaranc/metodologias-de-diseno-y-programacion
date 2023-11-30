package cl.uchile.dcc.citric
package model.states

import model.abstractclasses.AbstractState

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.Panel

class AppPanel extends AbstractState{

  override def doEffect(): Unit = {
    val panel: Panel = context.currentPanel.get
    val player: PlayerCharacter = context.currentPlayer.get
    panel.apply(player)
    context.setPlayer()
    context.setState(new Chapter())
  }

}
