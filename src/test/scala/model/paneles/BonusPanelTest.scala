package cl.uchile.dcc.citric
package model.paneles

import cl.uchile.dcc.citric.model.PlayerCharacter
import scala.util.Random

class BonusPanelTest extends munit.FunSuite {
  val player1: PlayerCharacter = new PlayerCharacter("Juan",6,6,7,
    4,6, new Random(11),0,1)
  val player2: PlayerCharacter = new PlayerCharacter("Pedro", 6, 6, 7,
    4, 6, new Random(11), 7, 2)

  def give_stars(player: PlayerCharacter): Unit = {
    val roll: Int = player.rollDice()
    val Norm: Int = player.norma
    val a = roll * Norm
    val b = roll * 3
    if (a <= b) {
      player.stars += a
    }
    else {
      player.stars += b
    }
  }

  /** tests of "give_stars" method */

  test("First stars"){
    assertEquals(player1.stars, 0)
    give_stars(player1)
    assertEquals(player1.stars != 0, true)
  }

  test("Giving more stars"){
    assertEquals(player2.stars, 7)
    give_stars(player2)
    assertEquals(player2.stars != 7, true)
  }
}
