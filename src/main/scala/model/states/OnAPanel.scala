package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.{GameState, Panel}

import scala.collection.mutable.ArrayBuffer


/** Represents the OnAPanel GameState.
 *
 * The OnAPanel GameState is the state where the current
 * player lands on a panel
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */


class OnAPanel (context: GameController) extends AbstractState (context){

  /** checks if the current Panel is empty, and then make the transition
   *
   * This function might be invoked when the GameController
   * wants to make a transition from the OnAPanel State
   *
   * */
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
