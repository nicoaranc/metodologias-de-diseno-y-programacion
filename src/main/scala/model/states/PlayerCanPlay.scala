package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.traits.GameState

class PlayerCanPlay (context: GameController) extends AbstractState (context){

  override def starsForPlayer(): Unit = {
    val playerStars: Int = context.currentPlayer.get.stars
    val starsGiven: Int = (context.chapters/5) + 1
    context.currentPlayer.get.stars_=(playerStars + starsGiven)
    context.setState(new Movement(context))
  }

}
