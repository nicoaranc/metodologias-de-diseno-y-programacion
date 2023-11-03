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

  def dead(): Boolean = {
    if (Hp == 0){
      return true
    }
    else{
      return false
    }
  }

  def rollDice_wu(): Int = {
    random_wu.nextInt(6) + 1
  }

  def can_attack(u: PlayerCharacter): Int = {
    if (u.Can_play){
      attacking()
    }
    else{
      throw new CannotAttack("The opponent player can't attack")
    }
  }

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
