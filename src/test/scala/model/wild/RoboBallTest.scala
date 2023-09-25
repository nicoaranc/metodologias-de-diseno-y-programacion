package cl.uchile.dcc.citric
package model.wild

class RoboBallTest extends munit.FunSuite {
  val npc: RoboBall = new RoboBall()

  test("RoboBall is alive?") {
    assertEquals(npc.dead(), false)
    npc.Hp = 0
    assertEquals(npc.dead(), true)
  }
}
