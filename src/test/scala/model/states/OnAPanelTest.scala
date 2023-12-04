package cl.uchile.dcc.citric
package model.states

import model.traits.{GameState, Panel}

import cl.uchile.dcc.citric.model.controller.GameController
import cl.uchile.dcc.citric.model.panels.{home, neutral}
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class OnAPanelTest extends munit.FunSuite {

  test("Transition to AppPanel state"){
    val player: PlayerCharacter = new PlayerCharacter("José", 3, 1, 1, 1, new Random(), new home())
    val state: GameState = new OnAPanel(new GameController())
    val controller: GameController = state.context
    val panel: Panel = new neutral()
    panel.addCharacter(player)
    controller.currentPanel = Some(panel)
    controller.currentPlayer = Some(player)
    controller.checkPanel()
    assertEquals(controller.state.isInstanceOf[AppPanel], true)
  }

  test("Transition to DecisionToFight state"){
    val player: PlayerCharacter = new PlayerCharacter("José", 3, 1, 1, 1, new Random(), new home())
    val player2: PlayerCharacter = new PlayerCharacter("Juan", 3, 1, 1, 1, new Random(), new home())
    val state: GameState = new OnAPanel(new GameController())
    val controller: GameController = state.context
    val panel: Panel = new neutral()
    panel.addCharacter(player)
    panel.addCharacter(player2)
    controller.currentPanel = Some(panel)
    controller.currentPlayer = Some(player)
    controller.checkPanel()
    assertEquals(controller.state.isInstanceOf[DecisionToFight], true)
  }

}
