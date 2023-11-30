package cl.uchile.dcc.citric
package model.states

import model.abstractclasses.AbstractState

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.Units

class OpponentAttacks extends AbstractState{

  override def checkHp(): Unit = {
    val player: PlayerCharacter = context.currentRival.get
    if (player.Hp == 0){
      context.setPlayer()
      context.setState(new Chapter())
    }
    else{
      context.setState(new AppPanel())
    }
  }

}
