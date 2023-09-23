package cl.uchile.dcc.citric
package model.panels

import scala.collection.mutable.ArrayBuffer
import model.traits.Panel
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.util.Random

class NeutralPanelTest extends munit.FunSuite {

  private val characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()
  private val player1: PlayerCharacter = new PlayerCharacter("pedro", 7, 4, 5,
    3, new Random(11))
  private val player2: PlayerCharacter = new PlayerCharacter("juan", 8, 6, 3,
    2, new Random(11))

  private val panel1: neutral = new neutral()
  private val panel2: neutral = new neutral()
  private var nextPanels: ArrayBuffer[Panel] = ArrayBuffer[Panel](panel1, panel2)

  def addCharacter(player: PlayerCharacter): Unit = {
    if (characters.indexOf(player) == -1) {
      characters.addOne(player)
    }
  }

  def removeCharacter(player: PlayerCharacter): Unit = {
    if (characters.indexOf(player) != -1) {
      val index: Int = characters.indexOf(player)
      characters.remove(index)
    }
  }
  /** the test of the methods of addCharacter and removeCharacter are going to take place here,
   * and the same methods are going to be in the other classes of Panel*/

  /** test of the "addCharacter" method */
  test("a player enter"){
    assertEquals(characters.isEmpty, true)
    addCharacter(player1)
    assertEquals(characters.isEmpty, false)
    addCharacter(player2)
  }

  /** test of "removeCharacter" method */
  test("a player leaves"){
    addCharacter(player1)
    addCharacter(player2)
    removeCharacter(player1)
    assertEquals(characters.isEmpty, false)
    removeCharacter(player2)
    assertEquals(characters.isEmpty, true)
  }
}
