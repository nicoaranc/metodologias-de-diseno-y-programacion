package cl.uchile.dcc.citric
package model.states

import model.traits.GameState

import cl.uchile.dcc.citric.model.controller.GameController
import cl.uchile.dcc.citric.model.panels.home
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.util.Random

class PlayerCanPlayTest extends munit.FunSuite {

  val state: GameState = new PlayerCanPlay(new GameController)
  val controller: GameController = state.context
  val player: PlayerCharacter = new PlayerCharacter("Gero", 3, 2, 3, 1,
                                      new Random(), new home())
  controller.currentPlayer = Some(player)

  test("Transition to Movement state"){
    controller.starsForPlayer()
    assertEquals(player.stars, 1)
    val state2: GameState = controller.state
    assertEquals(state2.isInstanceOf[Movement], true)
  }

}
