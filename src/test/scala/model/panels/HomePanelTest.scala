package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import scala.util.Random

class HomePanelTest extends munit.FunSuite {
  val panel_a: home = new home()
  val panel_b: home = new home()
  private val player1: PlayerCharacter = new PlayerCharacter("pedro", 7, 4, 5,
    3, new Random(11),panel_a)
  private val player2: PlayerCharacter = new PlayerCharacter("juan", 8, 6, 3,
    2, new Random(11),panel_b)

  val panel1: home = new home()



  /** test normaCheck */
}
