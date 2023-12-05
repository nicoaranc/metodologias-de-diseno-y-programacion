package cl.uchile.dcc.citric
package model.states

import model.controller.GameController

import cl.uchile.dcc.citric.model.events.NormaSixEvent
import cl.uchile.dcc.citric.model.norma.Norma6
import cl.uchile.dcc.citric.model.panels.Home
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.GameState

import scala.util.Random

class ChapterTest extends munit.FunSuite {


  test("New Chapter"){
    val state: GameState = new Chapter(new GameController())
    val controller: GameController = state.context
    assertEquals(controller.chapters, 1)
    assertEquals(controller.turns, 0)
    controller.turns = 4
    controller.newChapter()
    assertEquals(controller.chapters, 2)
    assertEquals(controller.turns, 0)
  }

  test("Transition to PlayerTurn state"){
    val state: GameState = new Chapter(new GameController())
    val controller: GameController = state.context
    controller.playTurn()
    val state2: GameState = controller.state
    assertEquals(state2.isInstanceOf[PlayerTurn], true)
  }

  test("Transition to EndGame"){
    val state: GameState = new Chapter(new GameController())
    val controller: GameController = state.context
    assertEquals(controller.finishedGame, false)
    val winnerPlayer: PlayerCharacter = new PlayerCharacter("Leonel", 2, 3, 4,
                                                    5, new Random(), new Home())
    winnerPlayer.norma_id_=(6)
    winnerPlayer.norma_=(new Norma6())
    winnerPlayer.addObserver(controller)
    controller.currentPlayer = Some(winnerPlayer)
    winnerPlayer.notifyObservers(new NormaSixEvent())
    assertEquals(controller.finishedGame, true)
    controller.normaSixReached()
    assertEquals(controller.state.isInstanceOf[EndGame], true)

  }

}
