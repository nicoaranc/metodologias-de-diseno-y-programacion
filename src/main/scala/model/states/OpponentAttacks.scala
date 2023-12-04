package cl.uchile.dcc.citric
package model.states

import model.abstractclasses.AbstractState

import cl.uchile.dcc.citric.model.controller.GameController
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.Units

class OpponentAttacks (context: GameController) extends AbstractState (context){

  override def checkHp(): Unit = {
    val player: PlayerCharacter = context.currentPlayer.get
    context.currentRival = None
    if (player.Hp == 0){
      context.setPlayer()
      context.setState(new Chapter(context))
    }
    else{
      context.setState(new AppPanel(context))
    }
  }

}
