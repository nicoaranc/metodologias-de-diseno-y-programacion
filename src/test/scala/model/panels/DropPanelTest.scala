package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import scala.util.Random

class DropPanelTest extends munit.FunSuite {

  val panel_a: Home = new Home()
  val panel_b: Home = new Home()
  val player1: PlayerCharacter = new PlayerCharacter("Juan", 6, 7,
    4, 6, new Random(11),panel_a)
  val player2: PlayerCharacter = new PlayerCharacter("Pedro", 6, 7,
    4, 6, new Random(11),panel_b)

  player1.stars = 4
  player2.stars = 34


  val panel1: Drop = new Drop()




  /** test of the "remove_stars" method */
  test("players lost their stars"){
    assertEquals(player1.stars, 4)
    assertEquals(player2.stars, 34)
    panel1.apply(player1)
    assertEquals(player1.stars != 4, true)
    panel1.apply(player2)
    assertEquals(player2.stars != 34, true)
  }
}
