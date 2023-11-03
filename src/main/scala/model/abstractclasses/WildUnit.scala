package cl.uchile.dcc.citric
package model.abstractclasses

import exceptions.CannotAttack
import model.player.PlayerCharacter
import model.traits.Units

import scala.util.Random

abstract class WildUnit extends Units{
  var Hp: Int

  val maxHp: Int

  val attack: Int

  val defense: Int

  val evasion: Int

  var stars: Int


  val random_wu: Random = new Random()

  /** checks if the Wild Unit is dead */
  def dead(): Boolean = {
    if (Hp == 0){
      return true
    }
    else{
      return false
    }
  }

  /** returns the result of the Wil Unit rolling a dice */
  def rollDice_wu(): Int = {
    random_wu.nextInt(6) + 1
  }

  /** checks if the Wild Unit can attack to a Player Character */
  def can_attack(u: PlayerCharacter): Int = {
    if (u.Can_play){
      attacking()
    }
    else{
      throw new CannotAttack("The opponent player can't attack")
    }
  }

  /** method of the attack of the Wild Unit*/
  def attacking(): Int = {
      val rollATK = rollDice_wu()
      if (rollATK + attack > 0){
        return rollATK + attack
      }
      else{
        return 0
      }
  }

}
