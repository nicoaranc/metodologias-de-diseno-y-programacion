package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.{GameState, Panel}

import scala.util.Random
import scala.util.control.Breaks.{break, breakable}

/** Represents the Movement GameState.
 *
 * The Movement GameState is the state where the current
 * player have to decide the path that depends of the Dice
 * that the player rolls
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class Movement (context: GameController) extends AbstractState (context){

  /** The current player rolls a Dice and choose the panel's path
   *
   * This function might be invoked when the GameController
   * wants to set the OnAPanel State from the Movement State
   *
   * */
  override def rollsDice(): Unit = {
    val number: Int = context.currentPlayer.get.rollDice()
    val player: PlayerCharacter = context.currentPlayer.get

    breakable {
      for (a <- 1 to number) {
        context.setPanel()
        val panel: Panel = context.currentPanel.get
        if (player.canStop(panel)) {
          val roll: Int = new Random().nextInt(2) + 1
          if (roll == 1) {
            break
          }
        }
      }
    }

    context.setState(new OnAPanel(context))

  }



}
