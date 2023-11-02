package cl.uchile.dcc.citric
package model.player
import model.panels.home
import cl.uchile.dcc.citric.model.traits.WildUnit
import cl.uchile.dcc.citric.model.wild.{Seagull, Chicken, RoboBall}
import exceptions.CannotAttack

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

    assertEquals(player1.Recovery, false)
    assertEquals(player1.Can_play, true)

    player1.Hp_=(0)
    player1.defeated()
    assertEquals(player1.Recovery, true)
    assertEquals(player1.Can_play, false)
  }

  test("A character earns victories winning a battle") {
    val panel1: home = new home()
    val player1 = new PlayerCharacter("npc", 5, 1, 1, -1, new Random(11),panel1)

    val panel2: home = new home()
    val player2 = new PlayerCharacter("npc", 5, 1, 1, -1, new Random(11),panel2)

    val a: Int = player1.victories
    player1.victories_perBattle(player2)
    assertEquals(a + 2, player1.victories)
    player1.victories = a

    val npc1: WildUnit = new RoboBall()
    val npc2: WildUnit = new Seagull()
    val npc3: WildUnit = new Chicken()

    player1.victories_perBattle(npc1)
    player1.victories_perBattle(npc2)
    player1.victories_perBattle(npc3)

    assertEquals(a + 3,player1.victories)
  }

  test("Count of stars when a player wins/loose against a WildUnit"){
    val panel1: home = new home()
    val player1 = new PlayerCharacter("npc", 5, 1, 1, -1, new Random(11), panel1)
    player1.stars_= (14)

    /** The player defeats every kind of wild unit */
    val npc1: RoboBall = new RoboBall()
    npc1.stars_= (4)
    player1.winStars_battle(npc1)
    assertEquals(player1.stars, 20)

    val npc2: Seagull = new Seagull()
    npc2.stars_= (2)
    player1.winStars_battle(npc2)
    assertEquals(player1.stars, 24)

    val npc3: Chicken = new Chicken()
    npc3.stars_=(1)
    player1.winStars_battle(npc3)
    assertEquals(player1.stars,28)

    /** The player is defeated by every kind of wild unit */
    player1.dropStars_battle(npc1)
    assertEquals(player1.stars,14)

    player1.dropStars_battle(npc2)
    assertEquals(player1.stars, 7)

    player1.dropStars_battle(npc3)
    assertEquals(player1.stars,3)
  }

  test("Count of stars when a player wins/loose against a other PlayerCharacter"){
    val panel1: home = new home()
    val player1 = new PlayerCharacter("Pedro", 5, 1, 1, -1, new Random(11), panel1)
    player1.stars_=(10)

    val panel2: home = new home()
    val player2 = new PlayerCharacter("Juan", 5, 1, 1, -1, new Random(11), panel2)
    player2.stars_=(8)

    val panel3: home = new home()
    val player3 = new PlayerCharacter("Diego", 5, 1, 1, -1, new Random(11), panel3)
    player3.stars_=(14)

    /** player1 defeats player2 */
    player1.winStars(player2)
    assertEquals(player1.stars, 14)
    player2.dropStars_battle(player1)
    assertEquals(player2.stars, 4)

    /** player3 defeats player1 */
    player3.winStars(player1)
    assertEquals(player3.stars, 21)
    player1.dropStars_battle(player3)
    assertEquals(player1.stars, 7)

    /** player2 defeats player3 */
    player2.winStars(player3)
    assertEquals(player2.stars, 14)
    player3.dropStars_battle(player2)
    assertEquals(player3.stars, 11)
  }

  test("Attacking"){
    val panel: home = new home()
    val player = new PlayerCharacter("Pedro", 5, 1, 1, -1, new Random(11),panel)

    /** attacking a npc */
    val npc: WildUnit = new RoboBall()
    val a: Int = player.can_attack(npc)
    assertEquals(a >= 0, true)

    /** attacking a PlayerCharacter */
    val panel2: home = new home()
    val player2 = new PlayerCharacter("Diego", 5, 1, 1, -1, new Random(11), panel2)
    val b: Int = player.can_attack(player2)
    assertEquals(b >= 0, true)
  }

  test("Attack isn't possible in many ways"){
    val panel: home = new home()
    val player = new PlayerCharacter("Pedro", 5, 1, 1, -1, new Random(11), panel)

    val panel2: home = new home()
    val player2 = new PlayerCharacter("Diego", 5, 1, 1, -1, new Random(11), panel2)

    val npc: WildUnit = new Chicken()

    /** player is in Recovery phase */
    player.Hp_=(0)
    player.defeated()

    intercept[CannotAttack]{
      player.can_attack(player2)
    }

    /** the playerCharacter rival is in Recovery phase */
    intercept[CannotAttack]{
      player2.can_attack(player)
    }

    /** the wild unit can't attack a PlayerCharacter in RecoveryPhase */
    intercept[CannotAttack]{
      npc.can_attack(player)
    }

    /** the player character can't attack to a dead wild unit */
    npc.Hp_= (0)
    intercept[CannotAttack]{
      player2.can_attack(npc)
    }

  }

  test("Defending"){
    val panel1: home = new home()
    val a: Int = 1
    val play1 = new PlayerCharacter("Pedro", 5, 1, 1, -1, new Random(11),panel1)
    play1.defending(a)
    assertEquals(play1.Hp, 4)

    val b: Int = 1000000000
    play1.defending(b)
    assertEquals(play1.Hp, 0)
  }

  test("Evading"){
    val panel1: home = new home()
    var a: Int = 0
    val play1 = new PlayerCharacter("Pedro", 5, 1, 1, -1, new Random(11),panel1)
    play1.evading(a)
    assertEquals(play1.Hp, 5)
    a = 10000
    play1.evading(a)
    assertEquals(play1.Hp, 0)
  }

  test("Norma Clear"){

  }

}
