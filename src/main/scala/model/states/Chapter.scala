package cl.uchile.dcc.citric
package model.states

import model.abstractclasses.AbstractState

import cl.uchile.dcc.citric.model.controller.GameController

/** Represents the Chapter GameState.
 *
 * The Chapter GameState is the state where the players finishes
 * their respective turns and checks the conditions to
 * end the game
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class Chapter (context: GameController) extends AbstractState (context){

  /** Checks if the GameController can set a new Chapter, and make the transition to the PlayerTurn state
   *
   * This function might be invoked when the GameController
   * wants to set the PlayerTurn State from the Chapter State
   *
   * */
  override def playTurn(): Unit = {
    context.newChapter()
    context.setState(new PlayerTurn(context))
  }

  /** Makes the transition to the EndGame state
   *
   * This function might be invoked when a player ends his
   * turn in Norma 6
   *
   * */
  override def normaSixReached(): Unit = {
    val name: String = context.winner.get.name
    println(s"The player $name won the game!")
    context.setState(new EndGame(context))
  }


}
