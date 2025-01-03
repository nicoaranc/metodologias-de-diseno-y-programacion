package cl.uchile.dcc.citric
package model.wild

import model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.abstractclasses.WildUnit

import scala.util.Random

import cl.uchile.dcc.citric.model.panels.Home

class RoboBallTest extends munit.FunSuite {
  val npc: RoboBall = new RoboBall()

  test("RoboBall is alive?") {
    assertEquals(npc.dead(), false)
    npc.Hp = 0
    assertEquals(npc.dead(), true)
  }

  test("Defending") {
    var a: Int = 1
    val npc = new RoboBall()
    npc.defending(a)
    assertEquals(npc.Hp, 2)
  }
  test("Evading") {
    var a: Int = 0
    val npc = new RoboBall()
    npc.evading(a)
    assertEquals(npc.Hp, 3)
    a = 10000
    npc.evading(a)
    assertEquals(npc.Hp, 0)
  }
}
