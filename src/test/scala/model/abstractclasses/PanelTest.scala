package cl.uchile.dcc.citric
package model.abstractclasses

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import model.panels.{bonus,home,neutral,drop,encounter}
import scala.util.Random

class PanelTest extends munit.FunSuite {

  val panel_a: home = new home()
  val panel_b: home = new home()

  val player1: PlayerCharacter = new PlayerCharacter("Juan", 6, 7,
    4, 6, new Random(11), panel_a)
  val player2: PlayerCharacter = new PlayerCharacter("Pedro", 6, 7,
    4, 6, new Random(11), panel_b)

  val panel1: home = new home()

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

  test("Adding/removing panels next to the current Panel") {
    assertEquals(panel1.nextPanels.isEmpty, true)
    val p1: bonus = new bonus()
    panel1.addPanel(p1)
    assertEquals(panel1.nextPanels.isEmpty, false)

    val p2: bonus = new bonus()
    val p3: encounter = new encounter()
    val p4: neutral = new neutral()
    val p5: drop = new drop()

    panel1.addPanel(p2)
    panel1.addPanel(p3)
    panel1.addPanel(p4)
    panel1.addPanel(p5)
    assertEquals(panel1.nextPanels.isEmpty, false)
    panel1.removePanel(p1)
    panel1.removePanel(p2)
    panel1.removePanel(p3)
    panel1.removePanel(p4)
    panel1.removePanel(p5)
    assertEquals(panel1.nextPanels.isEmpty,true)
  }
}