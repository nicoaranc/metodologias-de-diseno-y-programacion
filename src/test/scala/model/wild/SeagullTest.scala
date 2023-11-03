package cl.uchile.dcc.citric
package model.wild

import model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.abstractclasses.WildUnit

import scala.util.Random

import cl.uchile.dcc.citric.model.panels.home

class SeagullTest extends munit.FunSuite {
  val npc: Seagull = new Seagull()


  test("Seagull is alive?"){
    assertEquals(npc.dead(), false)
    npc.Hp = 0
    assertEquals(npc.dead(), true)
  }
  test("Attacking a WildUnit") {
    val panel1: home = new home()
    val npc: WildUnit = new Seagull()
    val player = new PlayerCharacter("Pedro", 5, 1, 1, -1, new Random(11),panel1)
 /** */
  }
  test("Defending") {
    var a: Int = 1
    val npc = new Seagull()
    npc.defending(a)
    assertEquals(npc.Hp, 2)
  }
  test("Evading") {
    var a: Int = 0
    val npc = new Seagull()
    npc.evading(a)
    assertEquals(npc.Hp, 3)
    a = 10000
    npc.evading(a)
    assertEquals(npc.Hp, 0)
  }
}
