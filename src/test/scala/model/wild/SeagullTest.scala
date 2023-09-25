package cl.uchile.dcc.citric
package model.wild

import model.player.PlayerCharacter
import scala.util.Random

class SeagullTest extends munit.FunSuite {
  val npc: Seagull = new Seagull()


  test("Seagull is alive?"){
    assertEquals(npc.dead(), false)
    npc.Hp = 0
    assertEquals(npc.dead(), true)
  }
}
