package cl.uchile.dcc.citric
package model.paneles

import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.citric.model.PlayerCharacter
import cl.uchile.dcc.citric.model.Panel
import scala.util.Random

class NeutralPanelTest extends munit.FunSuite {

  private val characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()
  private val player1: PlayerCharacter = new PlayerCharacter("pedro", 7, 7, 4, 5,
    3, new Random(11),0,1)
  private val player2: PlayerCharacter = new PlayerCharacter("juan", 8, 8, 6, 3,
    2, new Random(11),0,1)

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

  test("a player enter"){
    assertEquals(characters.isEmpty, true)
    addCharacter(player1)
    assertEquals(characters.isEmpty, false)
    addCharacter(player2)
  }
  test("a player leaves"){
    addCharacter(player1)
    addCharacter(player2)
    removeCharacter(player1)
    assertEquals(characters.isEmpty, false)
    removeCharacter(player2)
    assertEquals(characters.isEmpty, true)
  }
}
