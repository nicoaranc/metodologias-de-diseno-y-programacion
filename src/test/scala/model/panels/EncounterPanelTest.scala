package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.abstractclasses.WildUnit
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.wild.{Chicken, RoboBall, Seagull}

import scala.util.Random

class EncounterPanelTest extends munit.FunSuite {
  val panel_a: Home = new Home()
  val panel_b: Home = new Home()
  private val player1: PlayerCharacter = new PlayerCharacter("pedro", 7, 4, 5,
    3, new Random(11),panel_a)
  private val player2: PlayerCharacter = new PlayerCharacter("juan", 8, 6, 3,
    2, new Random(11),panel_b)

  private val panel1: Encounter = new Encounter()


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
    val p1: Encounter = new Encounter()
    panel1.addPanel(p1)
    assertEquals(panel1.nextPanels.isEmpty, false)
  }

  test("Fight against a Chicken in encounter panel"){
    val testPlayer: PlayerCharacter = new PlayerCharacter("Jose", 2, 400000, 5,
                                              3, new Random(), new Home())
    val testPanel: Encounter = new Encounter()
    testPanel.chicken = Some(new Chicken())
    testPanel.apply(testPlayer)
    assertEquals(testPanel.chicken, None)
    val testPlayer2: PlayerCharacter = new PlayerCharacter("Juan", 1, -400000, -1,
      -1, new Random(), new Home())
    testPanel.chicken = Some(new Chicken())
    testPanel.apply(testPlayer2)
    assertEquals(testPlayer2.Hp, 0)
  }

  test("Fight against a RoboBall in encounter panel") {
    val testPlayer3: PlayerCharacter = new PlayerCharacter("Jose", 2, 400000, 5,
      3, new Random(), new Home())
    val testPanel: Encounter = new Encounter()
    testPanel.roboBall = Some(new RoboBall())
    testPanel.apply(testPlayer3)
    assertEquals(testPanel.roboBall, None)
    val testPlayer4: PlayerCharacter = new PlayerCharacter("Juan", 1, -400000, -1000,
      -10000, new Random(), new Home())
    testPanel.roboBall = Some(new RoboBall())
    testPanel.apply(testPlayer4)
    assertEquals(testPlayer4.Hp, 0)
  }

  test("Fight against a Seagull in encounter panel") {
    val testPlayer: PlayerCharacter = new PlayerCharacter("Jose", 2, 400000, 5,
      3, new Random(), new Home())
    val testPanel: Encounter = new Encounter()
    testPanel.seagull = Some(new Seagull())
    testPanel.apply(testPlayer)
    assertEquals(testPanel.seagull, None)
    val testPlayer2: PlayerCharacter = new PlayerCharacter("Juan", 1, -400000, -1,
      -1, new Random(), new Home())
    testPanel.seagull = Some(new Seagull())
    testPanel.apply(testPlayer2)
    assertEquals(testPlayer2.Hp, 0)
  }

  test("Setting a wild unit for the encounter panel") {
    val testPlayer: PlayerCharacter = new PlayerCharacter("Jose", 2, -400000, 5,
      3, new Random(), new Home())
    val testPanel: Encounter = new Encounter()
    testPanel.apply(testPlayer)
    val a: Boolean = testPanel.chicken.isDefined
    val b: Boolean = testPanel.roboBall.isDefined
    val c: Boolean = testPanel.seagull.isDefined
    assertEquals(a || (b || c), true)

  }


}
