package cl.uchile.dcc.citric
package model.abstractclasses

import model.wild.{RoboBall,Chicken,Seagull}
import model.player.PlayerCharacter
import model.panels.home
import scala.util.Random

class WildUnitTest extends munit.FunSuite {



  test("getters & setters of the Wild Units"){
    val npc1: WildUnit = new RoboBall()
    val npc2: WildUnit = new Chicken()
    val npc3: WildUnit = new Seagull()

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


  test("Defending an attack"){
    val npc1: WildUnit = new RoboBall()
    val a: Int = npc1.Hp

    val panel1: home = new home()
    val player1 = new PlayerCharacter("Pedro", 5, 1, 1, -1, new Random(11), panel1)

    npc1.defending_to_PlayChar(player1)
    assertEquals(npc1.Hp != a, true)
  }


  test("Evading an attack") {
    val npc1: WildUnit = new RoboBall()


    val panel: home = new home()
    val player = new PlayerCharacter("Pedro", 5, 10000, 1, -1, new Random(11), panel)

    val panel2: home = new home()
    val player2 = new PlayerCharacter("Pedro2", 5, -10000, 1, -1, new Random(11), panel2)

    val a: Int = npc1.Hp
    npc1.evading_to_PlayChar(player2)
    assertEquals(npc1.Hp, a)
    npc1.evading_to_PlayChar(player)
    assertEquals(npc1.Hp, 0)
  }

}
