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

  def defending_to_PlayChar(u: PlayerCharacter): Unit = {
    if (u.Can_play) {
      val atk: Int = u.attacking()
      defending(atk)
    }
    else {
      throw new CannotAttack("Current player can't attack")
    }
  }
  def evading_to_PlayChar(u: PlayerCharacter): Unit = {
    if (u.Can_play) {
      val atk: Int = u.attacking()
      evading(atk)
    }
    else {
      throw new CannotAttack("Current player can't attack")
    }
  }

}
