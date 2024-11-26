package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.panels.Home
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.GameState

import scala.util.Random

class PlayerTurnTest extends munit.FunSuite {



  test("Transition to RecoveryPhase state"){
    val state: GameState = new PlayerTurn(new GameController())
    val controller: GameController = state.context
    controller.currentPlayer = Some(new PlayerCharacter("José", 0, 1, 1, 1, new Random(), new Home()))
    controller.checkHp()
    assertEquals(controller.turns, 1)
    val state2: GameState = controller.state
    assertEquals(state2.isInstanceOf[RecoveryPhase], true)
  }

  test("Transition to PlayerCanPlay state"){
    val state: GameState = new PlayerTurn(new GameController())
    val controller: GameController = state.context
    controller.currentPlayer = Some(new PlayerCharacter("José", 12, 1, 1, 1, new Random(), new Home()))
    controller.checkHp()
    assertEquals(controller.turns, 1)
    val state2: GameState = controller.state
    assertEquals(state2.isInstanceOf[PlayerCanPlay], true)
  }

}
