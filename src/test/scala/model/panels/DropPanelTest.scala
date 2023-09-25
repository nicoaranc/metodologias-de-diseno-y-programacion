package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import scala.util.Random

class DropPanelTest extends munit.FunSuite {
  val player1: PlayerCharacter = new PlayerCharacter("Juan", 6, 7,
    4, 6, new Random(11))
  val player2: PlayerCharacter = new PlayerCharacter("Pedro", 6, 7,
    4, 6, new Random(11))

  player1.stars = 4
  player2.stars = 34


  val panel1: drop = new drop()

  /** test of the "addCharacter" method */
  test("a player enter") {
    assertEquals(panel1.characters.isEmpty, true)
    panel1.addCharacter(player1)
    assertEquals(panel1.characters.isEmpty, false)
    panel1.addCharacter(player1)
    assertEquals(panel1.characters.size, 1)
  }

  /** test of "removeCharacter" method */
  test("a player leaves") {
    panel1.addCharacter(player1)
    panel1.addCharacter(player2)
    panel1.removeCharacter(player1)
    assertEquals(panel1.characters.isEmpty, false)
    panel1.removeCharacter(player2)
    panel1.removeCharacter(player1)
    assertEquals(panel1.characters.isEmpty, true)
  }

  test("Adding panels next to the current Panel") {
    assertEquals(panel1.nextPanels.isEmpty, true)
    val p1: drop = new drop()
    panel1.addPanel(p1)
    assertEquals(panel1.nextPanels.isEmpty, false)
  }


  /** test of the "remove_stars" method */
  test("players lost their stars"){
    assertEquals(player1.stars, 4)
    assertEquals(player2.stars, 34)
    panel1.remove_stars(player1)
    assertEquals(player1.stars != 4, true)
    panel1.remove_stars(player2)
    assertEquals(player2.stars != 34, true)
  }
}
