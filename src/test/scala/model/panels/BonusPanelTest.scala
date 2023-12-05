package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import model.panels.{Bonus,Home}
import scala.util.Random

class BonusPanelTest extends munit.FunSuite {
  val panel_a: Home = new Home()
  val panel_b: Home = new Home()

  val player1: PlayerCharacter = new PlayerCharacter("Juan",6,7,
    4,6, new Random(11),panel_a)
  val player2: PlayerCharacter = new PlayerCharacter("Pedro",6, 7,
    4, 6, new Random(11),panel_b)

  player2.stars = 7

  val panel1: Bonus = new Bonus()


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
