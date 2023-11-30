package cl.uchile.dcc.citric
package model.states

import model.abstractclasses.AbstractState

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.Units

class PlayerAttacks extends AbstractState{

  override def checkHp(): Unit = {
    val rival: PlayerCharacter = context.currentRival.get
    if (rival.Hp == 0){
      context.setState(new AppPanel())
    }
    else{
      val player: PlayerCharacter = context.currentPlayer.get
      rival.attacking_to(player)
      context.setState(new OpponentAttacks())
    }
  }

}
