package cl.uchile.dcc.citric
package model.states

import model.traits.{GameState, Panel}

import cl.uchile.dcc.citric.model.controller.GameController
import cl.uchile.dcc.citric.model.panels.{home, neutral}
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.util.Random

class MovementTest extends munit.FunSuite {

  val state: GameState = new Movement(new GameController())
  val controller: GameController = state.context
  val player: PlayerCharacter = new PlayerCharacter("Gero", 3, 2, 3, 1,
    new Random(), new home())

  val panel1: Panel = new neutral()
  val panel2: Panel = new neutral()
  val panel3: Panel = new neutral()
  val panel4: Panel = new neutral()
  val panel5: Panel = new neutral()
  val panel6: Panel = new neutral()
  val panel7: Panel = new neutral()


  /** This construction of the board of the game
   * is done to test the movement of the player, the
   * real construction of the board is different in
   * the final model of the game */

  panel1.addPanel(panel2)
  panel2.addPanel(panel3)
  panel3.addPanel(panel4)
  panel4.addPanel(panel5)
  panel5.addPanel(panel6)
  panel6.addPanel(panel7)

  controller.currentPanel = Some(panel1)
  controller.currentPlayer = Some(player)

  test("Movement and transition to OnAPanel state"){
    val initPanel: Panel = controller.currentPanel.get
    assertEquals(initPanel == panel1, true)
    controller.rollsDice()
    val endPanel: Panel = controller.currentPanel.get
    assertEquals(endPanel != panel1, true)
    assertEquals(controller.state.isInstanceOf[OnAPanel], true)
  }

}
