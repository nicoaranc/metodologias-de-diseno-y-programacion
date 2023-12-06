package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.abstractclasses.AbstractState
import cl.uchile.dcc.citric.model.board.Board
import cl.uchile.dcc.citric.model.traits.GameState

/** Represents the PreGame GameState.
 *
 * The PreGame GameState is the initial state
 * of the game
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class PreGame(context: GameController) extends AbstractState(context) {

  /** Starts the game with a particular 3x3 board
   *
   * This function might be invoked when the GameController
   * wants to start the game
   *
   * */
  override def startGame(): Unit = {
    val board: Board = new Board()
    board.construction()
    context.board = Some(board)
    for (player <- context.players){
      player.panel = Some(board.PanelsArray(5))
    }
    context.setState(new Chapter(context))
  }


}
