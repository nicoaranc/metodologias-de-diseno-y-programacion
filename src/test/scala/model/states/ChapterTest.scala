package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.traits.GameState

class ChapterTest extends munit.FunSuite {

  val state: GameState = new Chapter(new GameController())
  val controller: GameController = state.context

  test("New Chapter"){
    assertEquals(controller.chapters, 1)
    assertEquals(controller.turns, 0)
    controller.turns = 4
    controller.newChapter()
    assertEquals(controller.chapters, 2)
    assertEquals(controller.turns, 0)
  }

  test("Transition to PlayerTurn state"){
    controller.playTurn()
    val state2: GameState = controller.state
    assertEquals(state2.isInstanceOf[PlayerTurn], true)
  }

  test("Transition to EndGame"){

  }

}
