package cl.uchile.dcc.citric
package model.traits

import model.player.PlayerCharacter
import scala.util.Random

trait WildUnit extends Units{
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

  def attacking(u: PlayerCharacter): Int = {
    if (u.Can_play){
      val rollATK = rollDice_wu()
      if (rollATK + attack >= 0){
        return rollATK + attack
      }
      else{
        return 0
      }
    }
    else{
      return 0
    }
  }

  override def defending(a: Int): Unit = {
    val rollDEF = rollDice_wu()
    val receive = a - (rollDEF + defense)
    if (receive < 1){
      Hp -= 1
    }
    else{
      if (receive > Hp){
        Hp = 0
      }
      else{
        Hp -= receive
      }
    }
  }

  override def evading(a: Int): Unit = {
    val rollEVA = rollDice_wu()
    val aux = rollEVA + evasion
    if (aux > a){
      Hp = Hp
    }
    else{
      if (a > Hp){
        Hp = 0
      }
      else{
        Hp -= a
      }
    }
  }

}
