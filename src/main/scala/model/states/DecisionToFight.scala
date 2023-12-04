package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.GameState

import scala.util.Random

class DecisionToFight (context: GameController) extends AbstractState (context) {

  override def fight_decision(): Unit = {
    val roll: Int = new Random().nextInt(2) + 1
    if (roll == 1){
      context.setState(new AppPanel(context))
    }
    else{
      val player: PlayerCharacter = context.currentPlayer.get
      context.setRival()
      val rival: PlayerCharacter = context.currentRival.get
      player.attacking_to(rival)
      context.setState(new PlayerAttacks(context))
    }
  }

}
