package cl.uchile.dcc.citric
package model.states

import model.traits.{GameState, Panel}

import cl.uchile.dcc.citric.model.controller.GameController
import cl.uchile.dcc.citric.model.panels.{Home, Neutral}
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.util.Random

class AppPanelTest extends munit.FunSuite {

  val state: GameState = new AppPanel(new GameController())
  val controller: GameController = state.context
  val panel: Panel = new Neutral()
  controller.currentPanel = Some(panel)
  val player: PlayerCharacter = new PlayerCharacter("José", 3, 1, 1, 1, new Random(), new Home())
  controller.addPlayer(player)
  val player2: PlayerCharacter = new PlayerCharacter("Ronaldinho", 3, 1, 1, 1, new Random(), new Home())
  controller.addPlayer(player2)
  controller.currentPlayer = Some(player)

  test("Transition to Chapter state") {
    controller.doEffect()
    assertEquals(controller.state.isInstanceOf[Chapter], true)
  }

}
