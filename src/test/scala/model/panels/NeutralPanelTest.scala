package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.abstractclasses.AbsPanel
import scala.collection.mutable.ArrayBuffer
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.util.Random

class NeutralPanelTest extends munit.FunSuite {
  val panel_a: Home = new Home()
  val panel_b: Home = new Home()
  private val player1: PlayerCharacter = new PlayerCharacter("pedro", 7, 4, 5,
    3, new Random(11),panel_a)
  private val player2: PlayerCharacter = new PlayerCharacter("juan", 8, 6, 3,
    2, new Random(11),panel_b)

  private val panel1: Neutral = new Neutral()

  test("Apply from Neutral Panel"){
    panel1.apply(player1)
  }
}
