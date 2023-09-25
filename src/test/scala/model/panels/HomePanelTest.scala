package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import scala.util.Random

class HomePanelTest extends munit.FunSuite {

  private val player1: PlayerCharacter = new PlayerCharacter("pedro", 7, 4, 5,
    3, new Random(11))
  private val player2: PlayerCharacter = new PlayerCharacter("juan", 8, 6, 3,
    2, new Random(11))
  private val owner = player2

  def canStop(player: PlayerCharacter): Boolean = {
    if (player == owner) {
      return true
    }
    else {
      return false
    }
  }
  /** tests of the "stop" method */
  test("player can stop"){
    assertEquals(canStop(player2),true)
  }
  test("player can't stop"){
    assertEquals(canStop(player1),false)
  }

  /** test of the norma_check method */
}
