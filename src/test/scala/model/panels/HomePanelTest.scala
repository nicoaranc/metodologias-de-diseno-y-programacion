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

  val nom1: Norma = player1.NormaArray(0)
  val nom2: Norma = player1.NormaArray(1)
  val nom3: Norma = player1.NormaArray(2)

  /** test normaCheck */

  test("NormaCheck, checks if the current player can increase his norma"){
    /** to Norma 2 */
    player1.kind_goal_=("stars")
    player1.goal_= (nom2.stars_goal)
    panel_a.apply(player1)
    assertEquals((player1.norma,player1.norma_id), (nom1, 1))


    player1.stars_= (11)
    panel_a.apply(player1)
    assertEquals((player1.norma,player1.norma_id), (nom2, 2))

    /** to Norma3 */
    player1.kind_goal_=("victories")
    player1.goal_=(nom3.victories_goal)
    panel_a.apply(player1)
    assertEquals((player1.norma, player1.norma_id), (nom2, 2))

    player1.victories_=(3)
    panel_a.apply(player1)
    assertEquals((player1.norma, player1.norma_id), (nom3, 3))

  }
}
