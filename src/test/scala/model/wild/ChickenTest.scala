package cl.uchile.dcc.citric
package model.wild

class ChickenTest extends munit.FunSuite {
  val npc: Chicken = new Chicken()

  test("Chicken is alive?") {
    assertEquals(npc.dead(), false)
    npc.Hp = 0
    assertEquals(npc.dead(), true)
  }
}
