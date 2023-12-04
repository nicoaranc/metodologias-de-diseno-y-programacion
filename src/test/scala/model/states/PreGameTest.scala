package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.traits.GameState

class PreGameTest extends munit.FunSuite {

  val state: GameState = new PreGame(new GameController())
  val controller: GameController = state.context

  test("Initial setting and transition to Chapter state"){
    assertEquals(controller.state.isInstanceOf[PreGame],true)
    controller.startGame()
    val state2: GameState = controller.state
    assertEquals(state2.isInstanceOf[Chapter], true)
  }
}
