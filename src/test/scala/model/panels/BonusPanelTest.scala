package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import model.panels.{bonus,home}
import scala.util.Random

class BonusPanelTest extends munit.FunSuite {
  val panel_a: home = new home()
  val panel_b: home = new home()

  val player1: PlayerCharacter = new PlayerCharacter("Juan",6,7,
    4,6, new Random(11),panel_a)
  val player2: PlayerCharacter = new PlayerCharacter("Pedro",6, 7,
    4, 6, new Random(11),panel_b)

  player2.stars = 7

  val panel1: bonus = new bonus()

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
    val p1: bonus = new bonus()
    panel1.addPanel(p1)
    assertEquals(panel1.nextPanels.isEmpty, false)
  }

  /** tests of "give_stars" method */
  test("First stars"){
    assertEquals(player1.stars, 0)
    panel1.apply(player1)
    assertEquals(player1.stars != 0, true)
  }

  test("Giving more stars"){
    assertEquals(player2.stars, 7)
    panel1.apply(player2)
    assertEquals(player2.stars != 7, true)
  }
}
