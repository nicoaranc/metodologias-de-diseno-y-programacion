package cl.uchile.dcc.citric
package model.player
import model.panels.home
import cl.uchile.dcc.citric.model.wild.{Seagull, Chicken, RoboBall}
import cl.uchile.dcc.citric.model.abstractclasses.WildUnit
import model.traits.Norma

import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {
  /*
  REMEMBER: It is a good practice to use constants for the values that are used in multiple
  tests, so you can change them in a single place.
  This will make your tests more readable, easier to maintain, and less error-prone.
  */
  private val name = "testPlayer"
  private var Hp = 10
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private var randomNumberGenerator : Random = _
  private var stars = 0
  private var norma = 1
  private val panel_a : home = new home()
  /* Add any other constants you need here... */

  /*
  This is the object under test.
  We initialize it in the beforeEach method so we can reuse it in all the tests.
  This is a good practice because it will reset the object before each test, so you don't have
  to worry about the state of the object between tests.
  */
  private var character: PlayerCharacter = _  // <- x = _ is the same as x = null
  /* Add any other variables you need here... */

  // This method is executed before each `test(...)` method.
  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(11)
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      randomNumberGenerator,
      panel_a
    )
  }

  test("A character should have correctly set their attributes") {
    assertEquals(character.name, name)
    assertEquals(character.maxHp, maxHp)
    assertEquals(character.attack, attack)
    assertEquals(character.defense, defense)
    assertEquals(character.evasion, evasion)
  }

  // Two ways to test randomness (you can use any of them):

  // 1. Test invariant properties, e.g. the result is always between 1 and 6.
  test("A character should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(character.rollDice >= 1 && character.rollDice <= 6)
    }
  }

  // 2. Set a seed and test the result is always the same.
  // A seed sets a fixed succession of random numbers, so you can know that the next numbers
  // are always the same for the same seed.
  test("A character should be able to roll a dice with a fixed seed") {
    val other =
      new PlayerCharacter(name, maxHp, attack, defense, evasion, new Random(11),panel_a)
    for (_ <- 1 to 10) {
      assertEquals(character.rollDice(), other.rollDice())
    }
  }

  test("getters and setters"){
    val panel1: home = new home()
    val player1 = new PlayerCharacter("npc", 5, 1, 1, -1, new Random(11), panel1)

    /** Hit points */
    assertEquals(player1.Hp, 5)
    player1.Hp_=(3)
    assertEquals(player1.Hp, 3)

    /** Stars */
    assertEquals(player1.stars, 0)
    player1.stars_=(7)
    assertEquals(player1.stars, 7)

    /** Victories */
    assertEquals(player1.victories, 0)
    player1.victories_=(2)
    assertEquals(player1.victories, 2)

    /** Norma & Norma Id */
    val nom1: Norma = player1.NormaArray(0)
    val nom2: Norma = player1.NormaArray(1)

    assertEquals(player1.norma, nom1)
    assertEquals(player1.norma_id, 1)
    player1.norma_=(nom2)
    player1.norma_id_=(2)
    assertEquals(player1.norma, nom2)
    assertEquals(player1.norma_id, 2)

    /** Recovery & Can Play */
    assertEquals(player1.Recovery, false)
    assertEquals(player1.Can_play, true)
    player1.Recovery_=(true)
    player1.Can_play_=(false)
    assertEquals(player1.Recovery, true)
    assertEquals(player1.Can_play, false)

    /** Kind of Goal & Goal */
    assertEquals(player1.kind_goal, "")
    assertEquals(player1.goal, 0)
    player1.kind_goal_=("stars")
    player1.goal_=(10)
    assertEquals(player1.kind_goal, "stars")
    assertEquals(player1.goal, nom2.stars_goal)
    player1.kind_goal_=("victories")
    player1.goal_=(1)
    assertEquals(player1.kind_goal, "victories")
    assertEquals(player1.goal, nom2.victories_goal)
  }

  test("The player can/can't stop on the Home Panel") {
    val panel1: home = new home()
    val player1 = new PlayerCharacter("npc", 5, 1, 1, -1, new Random(11), panel1)

    val panel2: home = new home()
    val player2 = new PlayerCharacter("npc", 5, 1, 1, -1, new Random(11), panel2)

    val panel3: home = new home()

    assertEquals(player1.canStop(panel1), true)
    assertEquals(player1.canStop(panel2), false)
    assertEquals(player1.canStop(panel3), false)
    assertEquals(player2.canStop(panel2), true)
    assertEquals(player2.canStop(panel1), false)
    assertEquals(player2.canStop(panel3), false)

  }

  test("The player enters to the Recovery phase") {
    val panel1: home = new home()
    val player1 = new PlayerCharacter("npc", 5, 1, 1, -1, new Random(11), panel1)

    val npc: Seagull = new Seagull()

    assertEquals(player1.Recovery, false)
    assertEquals(player1.Can_play, true)

    player1.Hp_=(0)
    player1.defeated(npc)
    assertEquals(player1.Recovery, true)
    assertEquals(player1.Can_play, false)
  }

  test("A character wins/loose a battle") {
    val panel1: home = new home()
    val player1 = new PlayerCharacter("npc", 5, 1, 1, -1, new Random(11),panel1)

    val panel2: home = new home()
    val player2 = new PlayerCharacter("npc", 5, 1, 1, -1, new Random(11),panel2)
    player2.stars_=(6)

    player2.defeated(player1)
    assertEquals(player1.stars, 3)
    assertEquals(player2.stars, 3)
    assertEquals(player1.victories, 2)

    val npc1: RoboBall = new RoboBall()
    val npc2: Seagull = new Seagull()
    val npc3: Chicken = new Chicken()

    player2.defeated(npc1)
    assertEquals(player2.stars, 2)
    assertEquals(npc1.stars, 1)

    npc2.defeated(player1)
    assertEquals(npc2.stars, 0)
    assertEquals(player1.stars, 5)
    assertEquals(player1.victories,3)

    npc3.defeated(player1)
    assertEquals(npc3.stars, 0)
    assertEquals(player1.stars, 8)
    assertEquals(player1.victories,4)

    npc1.defeated(player1)
    assertEquals(npc1.stars, 0)
    assertEquals(player1.stars, 11)
    assertEquals(player1.victories,5)

  }


  test("Defending an attack"){
    val panel1: home = new home()
    val play1: PlayerCharacter = new PlayerCharacter("Pedro", 5, 1, 1, -1, new Random(11), panel1)

    /** from other PlayerCharacter */
    val panel2: home = new home()
    val play2: PlayerCharacter = new PlayerCharacter("Francesco", 5, 1, 1, -1, new Random(11), panel2)
    val a: Int = play1.Hp
    play1.defending_to_PlayChar(play2)
    assertEquals(play1.Hp != a, true)

    /** from a Chicken */
    val b: Int = play1.Hp
    val chicken: Chicken = new Chicken()
    play1.defending_to_Chicken(chicken)
    assertEquals(play1.Hp != b, true)

    /** from a RoboBall */
    val c: Int = play1.Hp
    val roboball: RoboBall = new RoboBall()
    play1.defending_to_RoboBall(roboball)
    assertEquals(play1.Hp != c, true)

    /** from a Seagull */
    val d: Int = play1.Hp
    val seagull: Seagull = new Seagull()
    play1.defending_to_Seagull(seagull)
    assertEquals(play1.Hp != d, true)
  }

  test("Evading an attack"){
    val panel4: home = new home()
    val play4: PlayerCharacter = new PlayerCharacter("Francesco", 5, 1, 1, -100000, new Random(11), panel4)

    val panel5: home = new home()
    val play5: PlayerCharacter = new PlayerCharacter("Martín", 5, 1, 1, 100000, new Random(11), panel5)


    /** from other PlayerCharacter */
    val panel6: home = new home()
    val play6: PlayerCharacter = new PlayerCharacter("Pedro", 5, 1, 1, -1, new Random(11), panel6)
    val a: Int = play5.Hp
    play5.evading_to_PlayChar(play6)
    assertEquals(play5.Hp, a)
    val b: Int = play4.Hp
    play4.evading_to_PlayChar(play6)
    assertEquals(play4.Hp != b, true)
    play4.Hp_=(play4.maxHp)


    /** from a Chicken */
    val chicken: Chicken = new Chicken()
    play5.evading_to_Chicken(chicken)
    assertEquals(play5.Hp, a)
    play4.evading_to_Chicken(chicken)
    assertEquals(play4.Hp != b, true)
    play4.Hp_= (play4.maxHp)

    /** from a RoboBall */
    val roboball: RoboBall = new RoboBall()
    play5.evading_to_RoboBall(roboball)
    assertEquals(play5.Hp, a)
    play4.evading_to_Chicken(chicken)
    assertEquals(play4.Hp != b, true)
    play4.Hp_= (play4.maxHp)

    /** from a Seagull */
    val seagull: Seagull = new Seagull()
    play5.evading_to_Seagull(seagull)
    assertEquals(play5.Hp, a)
    play4.evading_to_Seagull(seagull)
    assertEquals(play4.Hp != b, true)
    play4.Hp_=(play4.maxHp)


  }

}
