package cl.uchile.dcc.citric
package model.states

import model.traits.GameState

import cl.uchile.dcc.citric.model.controller.GameController
import cl.uchile.dcc.citric.model.panels.Home
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.util.Random

class OpponentAttacksTest extends munit.FunSuite {

  test("Transition to Chapter State"){
    val state: GameState = new OpponentAttacks(new GameController())
    val controller: GameController = state.context
    val player: PlayerCharacter = new PlayerCharacter("Juan", 0, 1, 1, 1, new Random(), new Home())
    controller.addPlayer(player)
    val player2: PlayerCharacter = new PlayerCharacter("Ronaldo", 3, 1, 1, 1, new Random(), new Home())
    controller.addPlayer(player2)
    controller.currentPlayer = Some(player)
    controller.checkHp()
    assertEquals(controller.state.isInstanceOf[Chapter], true)
  }

  test("Transition to Chapter State") {
    val state: GameState = new OpponentAttacks(new GameController())
    val controller: GameController = state.context
    val player: PlayerCharacter = new PlayerCharacter("Juan", 4, 1, 1, 1, new Random(), new Home())
    controller.addPlayer(player)
    val player2: PlayerCharacter = new PlayerCharacter("Ronaldo", 3, 1, 1, 1, new Random(), new Home())
    controller.addPlayer(player2)
    controller.currentPlayer = Some(player)
    controller.checkHp()
    assertEquals(controller.state.isInstanceOf[AppPanel], true)
  }

}
