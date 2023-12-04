package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.{GameState, Panel}

import scala.collection.mutable.ArrayBuffer

class OnAPanel (context: GameController) extends AbstractState (context){

  override def checkPanel(): Unit = {
    val panel: Panel = context.currentPanel.get
    val list: ArrayBuffer[PlayerCharacter] = panel.characters
    val size: Int = list.size
    if (size == 1){
      context.setState(new AppPanel(context))
    }
    else{
      context.setState(new DecisionToFight(context))
    }
  }

}
