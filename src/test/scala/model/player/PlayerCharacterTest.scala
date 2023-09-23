package cl.uchile.dcc.citric
package model.player

import cl.uchile.dcc.citric.model.wild.{Seagull, Chicken, RoboBall, WildUnit}

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
  private val randomNumberGenerator = new Random(11)
  private var stars = 0
  private var norma = 1
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
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      randomNumberGenerator,
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
      new PlayerCharacter(name, maxHp, attack, defense, evasion, new Random(11))
    for (_ <- 1 to 10) {
      assertEquals(character.rollDice(), other.rollDice())
    }
  }

  test("A character obtains stars per chapter"){
    val a: Int = character.stars
    character.stars_perChapter(1)
    assertEquals(a + (1/5) + 1, character.stars)
    character.stars = a
    character.stars_perChapter(11)
    assertEquals(a + (11/5) + 1, character.stars)
  }

  test("A character earns victories winning a battle") {
    val a: Int = character.victories
    val player2 = new PlayerCharacter("npc", 5, 1, 1, -1, new Random(11))
    character.victories_perBattle(player2)
    assertEquals(a + 2, character.victories)
    character.victories = a
    val npc1: WildUnit = new RoboBall()
    val npc2: WildUnit = new Seagull()
    val npc3: WildUnit = new Chicken()
    character.victories_perBattle(npc1)
    character.victories_perBattle(npc2)
    character.victories_perBattle(npc3)
    assertEquals(a + 3,character.victories)
  }

  test("Count of stars when a player wins/loose against a WildUnit"){
    character.stars = 14
    val a : Int = character.stars
    val npc1: WildUnit = new RoboBall()
    npc1.stars = 4
    val npc2: WildUnit = new Seagull()
    npc2.stars = 2
    val npc3: WildUnit = new Chicken()
    character.dropStars_battle(npc1)
    assertEquals(a/2,character.stars)
    assertEquals(4 + a/2, npc1.stars)
    character.stars = a
    character.winStars_battle(npc2)
    assertEquals(a + npc2.stars, character.stars)
    character.stars = a
    character.winStars_battle(npc3)
    assertEquals(a,character.stars)
  }
}
