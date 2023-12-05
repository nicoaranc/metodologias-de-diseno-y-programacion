package cl.uchile.dcc.citric
package model.states

import model.traits.GameState

import cl.uchile.dcc.citric.model.controller.GameController
import cl.uchile.dcc.citric.model.panels.Home
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.util.Random

class PlayerAttacksTest extends munit.FunSuite {



  test("Transition to AppPanel state"){
    val state: GameState = new PlayerAttacks(new GameController())
    val controller: GameController = state.context
    val player: PlayerCharacter = new PlayerCharacter("Juan", 0, 1, 1, 1, new Random(), new Home())
    controller.currentRival = Some(player)
    controller.checkHp()
    assertEquals(controller.state.isInstanceOf[AppPanel], true)
  }

  test("Transition to OpponentAttacks"){
    val state: GameState = new PlayerAttacks(new GameController())
    val controller: GameController = state.context
    val player: PlayerCharacter = new PlayerCharacter("Juan", 4, 1, 1, 1, new Random(), new Home())
    val player2: PlayerCharacter = new PlayerCharacter("José", 3, 1, 1, 1, new Random(), new Home())
    controller.currentRival = Some(player2)
    controller.currentPlayer = Some(player)
    controller.checkHp()
    assertEquals(controller.state.isInstanceOf[OpponentAttacks], true)

  }

}
