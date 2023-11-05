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

  /** returns the result of the Wild Unit rolling a dice */
  def rollDice_wu(): Int = {
    random_wu.nextInt(6) + 1
  }

  /** method of the attack of the Wild Unit */
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

  /** method of the defense of the Wild Unit */
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

  /** method of the evasion of the Wild Unit */
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

  /** method that stars an attack from a Wild Unit to a PlayerCharacter */
  /**
  def attacking_to_PlayChar(u: PlayerCharacter): Unit
   */

  /** method that make the defense of the Wild Unit from a PlayerCharacter's attack */
  def defending_to_PlayChar(u: PlayerCharacter): Unit = {
    if (u.Can_play && !dead()) {
      val atk: Int = u.attacking()
      defending(atk)
    }
    else {
      if (!u.Can_play) {
        throw new CannotAttack("Current player can't attack")
      }
      else{
        throw new CannotAttack("The Wild Unit is dead")
      }
    }
  }

  /** method that make the evade movement of the Wild Unit from a PlayerCharacter's attack */
  def evading_to_PlayChar(u: PlayerCharacter): Unit = {
    if (u.Can_play && !dead()) {
      val atk: Int = u.attacking()
      evading(atk)
    }
    else {
      if (!u.Can_play) {
        throw new CannotAttack("Current player can't attack")
      }
      else {
        throw new CannotAttack("The Wild Unit is dead")
      }
    }
  }

}
