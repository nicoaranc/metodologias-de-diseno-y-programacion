package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import model.traits.Norma
import model.norma.{Norma2, Norma3}
import scala.util.Random

class HomePanelTest extends munit.FunSuite {

  val panel_a: home = new home()
  val player1: PlayerCharacter = new PlayerCharacter("pedro", 7, 4, 5,
    3, new Random(11),panel_a)

  val nom2: Norma = player1.NormaArray(1)
  val nom3: Norma = player1.NormaArray(2)

  /** test normaCheck */

  test("NormaCheck, checks if the current player can increase his norma"){
    /** to Norma 2 */
    player1.kind_goal_=("stars")
    player1.goal_= (nom2.stars_goal)
    assertEquals(panel_a.apply(player1), false)

    player1.stars_= (11)
    assertEquals(panel_a.apply(player1), true)

    /** to Norma3 */
    player1.kind_goal_=("victories")
    player1.goal_=(nom3.victories_goal)
    assertEquals(panel_a.apply(player1), false)

    player1.victories_=(3)
    assertEquals(panel_a.apply(player1), true)

  }
}
