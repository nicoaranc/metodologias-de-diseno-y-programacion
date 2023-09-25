package cl.uchile.dcc.citric
package model.player

import model.norma.{Norma1,Norma2,Norma3,Norma4,Norma5,Norma6}
import model.traits.{Norma, Units, WildUnit}

import scala.util.Random
import scala.collection.mutable.ArrayBuffer

/** The `PlayerCharacter` class represents a character or avatar in the game, encapsulating
  * several attributes such as health points, attack strength, defense capability,
  * and evasion skills. Each player has a unique name, and throughout the game,
  * players can collect stars, roll dice, and progress in levels known as 'norma'.
  * This class not only maintains the state of a player but also provides methods
  * to modify and interact with these attributes.
  *
  * For instance, players can:
 *
  * - Increase or decrease their star count.
 *
  * - Roll a dice, a common action in many board games.
 *
  * - Advance their norma level.
  *
  * Furthermore, the `Player` class has a utility for generating random numbers,
  * which is primarily used for simulating dice rolls. By default, this utility is
  * an instance of the `Random` class but can be replaced if different random
  * generation behaviors are desired.
  *
  * @param name The name of the player. This is an identifier and should be unique.
  * @param maxHp The maximum health points a player can have. It represents the player's endurance.
  * @param attack The player's capability to deal damage to opponents.
  * @param defense The player's capability to resist or mitigate damage from opponents.
  * @param evasion The player's skill to completely avoid certain attacks.
  * @param randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
  *                              instance.
  *
  * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/~Your github account~/ ~Your Name~]]
  */
class PlayerCharacter(val name: String,
              val maxHp: Int,
              val attack: Int,
              val defense: Int,
              val evasion: Int,
              val randomNumberGenerator: Random = new Random()) extends Units{

  private val n1: Norma = new Norma1()
  private val n2: Norma = new Norma2()
  private val n3: Norma = new Norma3()
  private val n4: Norma = new Norma4()
  private val n5: Norma = new Norma5()
  private val n6: Norma = new Norma6()

  var Hp: Int = maxHp
  var stars: Int = 0
  var norma: Norma = n1
  var norma_id: Int = 1
  var victories: Int = 0
  var Recovery: Boolean = false
  var Can_play: Boolean = true
  var NormaArray: ArrayBuffer[Norma] = new ArrayBuffer[Norma]()
  NormaArray.addOne(n1)
  NormaArray.addOne(n2)
  NormaArray.addOne(n3)
  NormaArray.addOne(n4)
  NormaArray.addOne(n5)
  NormaArray.addOne(n6)

  var goal: Int = 0
  var kind_goal: String = ""

  /**
  def def_objective(): Unit = {
    if (Input to stars goal) {
      goal = (NormaArray[norma_id]).stars
      kind_goal = "stars"
    }
    if (Input to victories goal) {
      goal = (NormaArray[norma_id]).victories
      kind_goal = "victories"
    }
  }
  */

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }

  /** The player wins some stars at the beginning of the turn
  def stars_perChapter(c: Int): Unit = {
    stars += (c/5) + 1
  }
   */

  /** when the player defeats a Wild Unit wins one victory to the count */
  def victories_perBattle(u: WildUnit): Unit = {
    victories += 1
  }

  /** when the player defeats another Player wins two victories to the count */
  def victories_perBattle(u: PlayerCharacter): Unit = {
    victories += 2
  }

  /** when the player is defeated by a Wild Unit, drops the half of the stars and gives it to the Wild Unit */
  def dropStars_battle(u: WildUnit): Unit = {
    u.stars += stars/2
    stars = stars/2
  }

  /** when the player defeats a Wild Unit, wins the mount of stars that the Wild Unit have */
  def winStars_battle(u: WildUnit): Unit = {
    stars += u.stars
  }

  def defeated(): Unit = {
    if (Hp == 0){
      Recovery = true
      Can_play = false
    }
  }


  /** when the player's Hp drops to 0, the player enters to the Recovery phase */
  /** if (Hp == 0){
    Recovery = true
  }
  */

  /** the process to leave the Recovery phase */
  /** if (Recovery){
    Can_play = false
    var q: Int = 6
    while(Recovery){
      var dice: Int = rollDice()
      if (dice >= q){
        Can_play = true
        q = 6
        Recovery = false
      }
      q -= 1 // the condition to leave the Recovery phase decreases 1 when pass one turn
    }
  } */
}
