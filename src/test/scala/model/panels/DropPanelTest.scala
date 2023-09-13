package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.PlayerCharacter
import scala.util.Random

class DropPanelTest extends munit.FunSuite {
  val player1: PlayerCharacter = new PlayerCharacter("Juan", 6, 6, 7,
    4, 6, new Random(11), 4, 1)
  val player2: PlayerCharacter = new PlayerCharacter("Pedro", 6, 6, 7,
    4, 6, new Random(11), 34, 4)

  def remove_stars(player: PlayerCharacter): Unit = {
    val q: Int = player.rollDice() * player.norma
    if (q >= player.stars) {
      player.stars = 0
    }
    else {
      player.stars -= q
    }
  }

  /** test of the "remove_stars" method */
  test("players lost their stars"){
    assertEquals(player1.stars, 4)
    assertEquals(player2.stars, 34)
    remove_stars(player1)
    assertEquals(player1.stars != 4, true)
    remove_stars(player2)
    assertEquals(player2.stars != 34, true)
  }
}
