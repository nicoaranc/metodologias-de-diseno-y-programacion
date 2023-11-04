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

  test("Winning some stars") {
    val npc1: WildUnit = new RoboBall()
    val npc2: WildUnit = new Chicken()
    val npc3: WildUnit = new Seagull()

    val panel1: home = new home()
    val player1 = new PlayerCharacter("Pedro", 5, 1, 1, -1, new Random(11), panel1)
    player1.stars_=(10)
    assertEquals(npc1.stars, 0)
    npc1.winStars(player1)
    player1.dropStars_battle(npc1)
    assertEquals(npc1.stars, 5)

    npc2.winStars(player1)
    player1.dropStars_battle(npc2)
    assertEquals(npc2.stars, 2)

    npc3.winStars(player1)
    player1.dropStars_battle(npc3)
    assertEquals(npc3.stars, 1)
  }

  test("attacking a PlayerCharacter"){
    val npc1: WildUnit = new RoboBall()
    val npc2: WildUnit = new Chicken()
    val npc3: WildUnit = new Seagull()

    val panel: home = new home()
    val player = new PlayerCharacter("Pedro", 5, 1, 1, -1, new Random(11), panel)

    val a: Int = npc1.can_attack(player)
    assertEquals(a >= 0, true)
    val b: Int = npc2.can_attack(player)
    assertEquals(b >= 0, true)
    val c: Int = npc3.can_attack(player)
    assertEquals(c >= 0, true)
  }

}
