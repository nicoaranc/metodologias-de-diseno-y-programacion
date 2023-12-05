package cl.uchile.dcc.citric
package model.states

import model.traits.GameState

import cl.uchile.dcc.citric.model.controller.GameController
import cl.uchile.dcc.citric.model.panels.Home
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.util.Random

class RecoveryPhaseTest extends munit.FunSuite {

  test("Roll a Dice is unnecessary to leave Recovery phase"){
    val state: GameState = new RecoveryPhase(new GameController())
    val controller: GameController = state.context
    val player: PlayerCharacter = new PlayerCharacter("Marcelo", 3, 4,
      3, 4, new Random(), new Home())
    val player2: PlayerCharacter = new PlayerCharacter("Iván", 3, 4,
      3, 4, new Random(), new Home())
    val player3: PlayerCharacter = new PlayerCharacter("Carlos", 3, 4,
      3, 4, new Random(), new Home())
    val player4: PlayerCharacter = new PlayerCharacter("Eduardo", 3, 4,
      3, 4, new Random(), new Home())
    controller.addPlayer(player)
    controller.addPlayer(player2)
    controller.addPlayer(player3)
    controller.addPlayer(player4)
    player.Recovery_=(true)
    player.Can_play_=(false)
    controller.currentPlayer = Some(player)
    controller.chapters = 6
    player.recoveryChapter = 1
    controller.rollsDice()
    assertEquals(player.Recovery, false)
    assertEquals(player.Can_play, true)
    assertEquals(controller.state.isInstanceOf[PlayerCanPlay], true)
  }

  test("Player in Recovery phase tries to play a turn"){
    val state: GameState = new RecoveryPhase(new GameController())
    val controller: GameController = state.context
    val player: PlayerCharacter = new PlayerCharacter("Marcelo", 3, 4,
      3, 4, new Random(), new Home())
    val player2: PlayerCharacter = new PlayerCharacter("Iván", 3, 4,
      3, 4, new Random(), new Home())
    val player3: PlayerCharacter = new PlayerCharacter("Carlos", 3, 4,
      3, 4, new Random(), new Home())
    val player4: PlayerCharacter = new PlayerCharacter("Eduardo", 3, 4,
      3, 4, new Random(), new Home())
    controller.addPlayer(player)
    controller.addPlayer(player2)
    controller.addPlayer(player3)
    controller.addPlayer(player4)
    player.Recovery_=(true)
    player.Can_play_=(false)
    controller.currentPlayer = Some(player)
    controller.chapters = 6
    player.recoveryChapter = 3
    controller.rollsDice()
    assertEquals(controller.state.isInstanceOf[RecoveryPhase], false)
  }

  test("Player in first time on Recovery phase tries to play a turn") {
    val state: GameState = new RecoveryPhase(new GameController())
    val controller: GameController = state.context
    val player: PlayerCharacter = new PlayerCharacter("Marcelo", 3, 4,
      3, 4, new Random(), new Home())
    val player2: PlayerCharacter = new PlayerCharacter("Iván", 3, 4,
      3, 4, new Random(), new Home())
    val player3: PlayerCharacter = new PlayerCharacter("Carlos", 3, 4,
      3, 4, new Random(), new Home())
    val player4: PlayerCharacter = new PlayerCharacter("Eduardo", 3, 4,
      3, 4, new Random(), new Home())
    controller.addPlayer(player)
    controller.addPlayer(player2)
    controller.addPlayer(player3)
    controller.addPlayer(player4)
    player.Can_play_=(false)
    controller.currentPlayer = Some(player)
    controller.chapters = 6
    player.recoveryChapter = 3
    controller.rollsDice()
    assertEquals(controller.state.isInstanceOf[RecoveryPhase], false)
  }


}
