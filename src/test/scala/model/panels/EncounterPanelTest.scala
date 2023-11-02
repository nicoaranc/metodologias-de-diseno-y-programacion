package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import scala.util.Random
import model.traits.WildUnit

class EncounterPanelTest extends munit.FunSuite {
  val panel_a: home = new home()
  val panel_b: home = new home()
  private val player1: PlayerCharacter = new PlayerCharacter("pedro", 7, 4, 5,
    3, new Random(11),panel_a)
  private val player2: PlayerCharacter = new PlayerCharacter("juan", 8, 6, 3,
    2, new Random(11),panel_b)

  private val panel1: encounter = new encounter()


  /** the test of the methods of addCharacter and removeCharacter are going to take place here,
   * and the same methods are going to be in the other classes of Panel */

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
    val p1: encounter = new encounter()
    panel1.addPanel(p1)
    assertEquals(panel1.nextPanels.isEmpty, false)
  }

  test("battle against a random Wild Unit"){
    val npc: WildUnit = panel1.apply()
    assertEquals(npc != null, true)
  }
}
