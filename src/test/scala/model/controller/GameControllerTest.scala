package cl.uchile.dcc.citric
package model.controller

import cl.uchile.dcc.citric.model.panels.{Home, Neutral}
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.Panel

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class GameControllerTest extends munit.FunSuite {

  test("Setting all the players"){
    val controller: GameController = new GameController()
    val player1: PlayerCharacter = new PlayerCharacter("Juan", 1, 1, 1, 1, new Random(), new Home())
    val player2: PlayerCharacter = new PlayerCharacter("Diego", 1, 1, 1, 1, new Random(), new Home())
    val player3: PlayerCharacter = new PlayerCharacter("Martín", 1, 1, 1, 1, new Random(), new Home())
    val player4: PlayerCharacter = new PlayerCharacter("Pedro", 1, 1, 1, 1, new Random(), new Home())
    val playersArray: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()
    playersArray.addOne(player1)
    playersArray.addOne(player2)
    playersArray.addOne(player3)
    playersArray.addOne(player4)
    controller.setOrder(playersArray)
    assertEquals(controller.currentPlayer.isDefined, true)
  }

  test("Setting Rivals"){
    val controller: GameController = new GameController()
    val player1: PlayerCharacter = new PlayerCharacter("Juan",1,1,1,1, new Random(), new Home())
    val player2: PlayerCharacter = new PlayerCharacter("Diego",1,1,1,1, new Random(), new Home())
    val player3: PlayerCharacter = new PlayerCharacter("Martín",1,1,1,1, new Random(), new Home())
    val player4: PlayerCharacter = new PlayerCharacter("Pedro",1,1,1,1, new Random(), new Home())
    controller.addPlayer(player1)
    controller.addPlayer(player2)
    controller.addPlayer(player3)
    controller.addPlayer(player4)
    val panel: Panel = new Neutral()
    panel.addCharacter(player1)
    panel.addCharacter(player2)
    panel.addCharacter(player3)
    panel.addCharacter(player4)
    controller.currentPlayer = Some(player1)
    controller.currentPanel = Some(panel)
    assertEquals(controller.currentRival.isEmpty, true)
    controller.setRival()
    assertEquals(controller.currentRival.isDefined, true)
  }

}
