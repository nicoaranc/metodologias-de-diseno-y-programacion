package cl.uchile.dcc.citric
package model.wild

import model.player.PlayerCharacter
import scala.util.Random
import model.traits.WildUnit

class ChickenTest extends munit.FunSuite {
  val npc: Chicken = new Chicken()

  test("Chicken is alive?") {
    assertEquals(npc.dead(), false)
    npc.Hp = 0
    assertEquals(npc.dead(), true)
  }
  test("Attacking a player") {
    val npc: WildUnit = new Chicken()
    val player = new PlayerCharacter("Pedro", 5, 1, 1, -1, new Random(11))
    val aux: Int = npc.attacking(player)
    assertEquals(aux != 0, true)
  }

  test("Defending") {
    var a: Int = 1
    val npc = new Chicken()
    npc.defending(a)
    assertEquals(npc.Hp, 2)
  }
  test("Evading") {
    var a: Int = 0
    val npc = new Chicken()
    npc.evading(a)
    assertEquals(npc.Hp, 3)
    a = 10000
    npc.evading(a)
    assertEquals(npc.Hp, 0)
  }

}
