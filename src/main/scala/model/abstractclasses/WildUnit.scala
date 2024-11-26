package cl.uchile.dcc.citric
package model.abstractclasses

import exceptions.CannotAttack
import model.player.PlayerCharacter
import model.traits.Units

import scala.util.Random

/** Represents a single wild unit, that it could be a Chicken, RoboBall or a Seagull.
 *
 * Each wild unit have their own stats and different bonus when is defeated by a player.
 * Also a wild unit can attack, defend and evade while a battle is happening, rolls a dice too
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

abstract class WildUnit extends Units {


  /** to give random numbers, mainly for the battle */
  private val random_wu: Random = new Random()


  /** Checks if the Wild Unit is dead.
   *
   * This might be invoked when battle starts.
   *
   */
  def dead(): Boolean = {
    if (Hp == 0){
      return true
    }
    else{
      return false
    }
  }

  /** Rolls a dice, returns a number between 1 to 6.
   *
   * This might be invoked when the wild unit is attacking, defending, or evading.
   *
   */
  private def rollDice_wu(): Int = {
    random_wu.nextInt(6) + 1
  }

  /** Makes the attack, return the attack points.
   *
   * This function might be invoked when the battle starts.
   *
   */
  def attacking(): Int = {
    val rollATK = rollDice_wu()
    val aux = rollATK + attack
    if (aux > 0) {
      return aux
    }
    else {
      return 0
    }
  }

  /** Makes the defense of the player.
   *
   * This function might be invoked during the battle.
   *
   * @param a The attack points to defend.
   */
  def defending(a: Int): Unit = {
    val rollDEF = rollDice_wu()
    val receive = a - (rollDEF + defense)
    if (receive < 1) {
      val b = Hp - 1
      Hp_=(b)
    }
    else {
      if (receive >= Hp) {
        Hp_=(0)
      }
      else {
        val b = Hp - receive
        Hp_=(b)
      }
    }
  }

  /** Makes the evasion of the player.
   *
   * This function might be invoked during the battle.
   *
   * @param a The attack points to evade.
   */
  def evading(a: Int): Unit = {
    val rollEVA = rollDice_wu()
    val aux = rollEVA + evasion

    if (aux > a) {
      return
    }
    else {
      if (a > Hp) {
        Hp_=(0)
      }
      else {
        val b = Hp - a
        Hp_=(b)
      }
    }
  }



  /** Starts the defense of the wild unit.
   *
   * This function might be invoked when the battle starts.
   *
   * @param u The attacking player.
   */
  def defending_to_PlayChar(u: PlayerCharacter): Unit = {
    if (u.Can_play && !dead()) {
      val atk: Int = u.attacking()
      defending(atk)
    }
    else {
      impossibleToFight(u)
    }
  }

  /** Starts the evasion of the wild unit.
   *
   * This function might be invoked when the battle starts.
   *
   * @param u The attacking player.
   */
  def evading_to_PlayChar(u: PlayerCharacter): Unit = {
    if (u.Can_play && !dead()) {
      val atk: Int = u.attacking()
      evading(atk)
    }
    else {
      impossibleToFight(u)
    }
  }

  private def impossibleToFight(u: PlayerCharacter): Unit = {
    if (!u.Can_play) {
      throw new CannotAttack("Current player can't attack")
    }
    else if (dead()) {
      throw new CannotAttack("Rival is in Recovery phase")
    }
  }

}
