package cl.uchile.dcc.citric
package model.abstractclasses

import model.wild.{RoboBall,Chicken,Seagull}

class WildUnitTest extends munit.FunSuite {

  val npc1: WildUnit = new RoboBall()
  val npc2: WildUnit = new Chicken()
  val npc3: WildUnit = new Seagull()

  test("getters & setters of the Wild Units"){

    /** Hit Points */
    assertEquals(npc1.Hp, 3)
    assertEquals(npc2.Hp, 3)
    assertEquals(npc3.Hp, 3)

    npc1.Hp_=(2)
    npc2.Hp_=(1)

    assertEquals(npc1.Hp, 2)
    assertEquals(npc2.Hp, 1)
    assertEquals(npc3.Hp, 3)

    /** Stars */
    assertEquals(npc1.stars, 0)
    assertEquals(npc2.stars, 0)
    assertEquals(npc3.stars, 0)

    npc1.stars_=(5)
    npc2.stars_=(2)
    npc3.stars_=(8)

    assertEquals(npc1.stars, 5)
    assertEquals(npc2.stars, 2)
    assertEquals(npc3.stars, 8)
  }

}
