package cl.uchile.dcc.citric
package model.states

import model.traits.{GameState, Panel}

import cl.uchile.dcc.citric.model.controller.GameController
import cl.uchile.dcc.citric.model.panels.{home, neutral}
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.util.Random

class DecisionToFightTest extends munit.FunSuite {

  val panel: Panel = new neutral()
  val state: GameState = new DecisionToFight(new GameController())
  val controller: GameController = state.context
  val player: PlayerCharacter = new PlayerCharacter("Juan", 3, 1, 1, 1, new Random(), new home())
  val player2: PlayerCharacter = new PlayerCharacter("José", 3, 1, 1, 1, new Random(), new home())
  panel.addCharacter(player)
  panel.addCharacter(player2)

  controller.currentPlayer = Some(player)
  controller.currentPanel = Some(panel)

  test("Transition from DecisionToFight state"){
    controller.fight_decision()
    val a: Boolean = controller.state.isInstanceOf[PlayerAttacks]
    val b: Boolean = controller.state.isInstanceOf[AppPanel]
    assertEquals(a || b, true)
  }

}
