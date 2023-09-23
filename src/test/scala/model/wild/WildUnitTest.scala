package cl.uchile.dcc.citric
package model.wild

import model.wild.Chicken
import model.wild.RoboBall
import model.wild.Seagull
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import scala.util.Random

class WildUnitTest extends munit.FunSuite {
  val npc1: Chicken = new Chicken()
  val npc2: RoboBall = new RoboBall()
  val npc3: Seagull = new Seagull()

  val player1: PlayerCharacter = new PlayerCharacter("Nicolás", 10, 6, 4, 4,
                                  new Random(11))
  val player2: PlayerCharacter = new PlayerCharacter("Tobías", 7, 9, 3, 7,
                                  new Random(11))

  test("NPCs are alive?"){
    assertEquals(npc1.dead(), false)
    assertEquals(npc2.dead(), false)
    assertEquals(npc3.dead(), false)
    npc1.Hp = 0
    npc2.Hp = 1
    npc3.Hp = 0
    assertEquals(npc1.dead(), true)
    assertEquals(npc2.dead(), false)
    assertEquals(npc3.dead(), true)
  }

  test("NPCs wins some stars"){
    assertEquals(npc1.stars,0)
    assertEquals(npc2.stars,0)
    assertEquals(npc3.stars,0)
    player1.stars = 14
    player2.stars = 15
    npc1.winStars(player1)
    npc2.winStars(player1)
    npc3.winStars(player2)
    assertEquals(npc1.stars, 7)
    assertEquals(npc2.stars, 7)
    assertEquals(npc3.stars, 7)
  }
}
