package cl.uchile.dcc.citric
package model.player

import model.norma.Norma1
import model.traits.{Norma, Units}
import cl.uchile.dcc.citric.model.wild.WildUnit

import scala.util.Random

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
  var Hp: Int = maxHp
  var stars: Int = 0
  var norma: Int = 1
  var victories: Int = 0
  private var Recovery: Boolean = false
  private var Can_play: Boolean = true

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }

  def stars_perChapter(c: Int): Unit = {
    stars += (c/5) + 1
  }

  def victories_perBattle(u: WildUnit): Unit = {
    victories += 1
  }

  def victories_perBattle(u: PlayerCharacter): Unit = {
    victories += 2
  }

  def dropStars_battle(u: WildUnit): Unit = {
    u.stars += stars/2
    stars = stars/2
  }

  def winStars_battle(u: WildUnit): Unit = {
    stars += u.stars
  }

  if (Hp == 0){
    Recovery = true
  }

  if (Recovery){
    Can_play = false
    var q: Int = 6
    while(Recovery){
      var dice: Int = rollDice()
      if (dice >= q){
        Can_play = true
        q = 6
        Recovery = false
      }
      q -= 1
    }
  }
}
