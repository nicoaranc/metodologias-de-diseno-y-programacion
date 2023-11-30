package cl.uchile.dcc.citric
package model.states

import model.controller.Gamecontroller

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.{GameState, Panel}

import scala.collection.mutable.ArrayBuffer

class OnAPanel extends AbstractState{

  override def checkPanel(): Unit = {
    val panel: Panel = context.currentPanel.get
    val list: ArrayBuffer[PlayerCharacter] = panel.characters
    if (list.isEmpty){
      context.setState(new AppPanel())
    }
    else{
      context.setState(new DecisionToFight())
    }
  }

}
