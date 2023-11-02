package cl.uchile.dcc.citric
package model.wild

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.WildUnit

class Seagull extends WildUnit {

  /** Seagull stats */

  val maxHp: Int = 3

  private var _Hp: Int = maxHp
  def Hp: Int = _Hp
  def Hp_=(NewHp: Int): Unit = {
    _Hp = NewHp
  }

  val attack: Int = 1

  val defense: Int = -1

  val evasion: Int = -1

  private var _stars: Int = 0
  def stars: Int = _stars
  def stars_=(NewStars: Int): Unit = {
    _stars = NewStars
  }


  def winStars(p: PlayerCharacter) = {
    val a: Int = p.stars / 2
    val b: Int = stars + a
    stars_=(b)
  }

  override def defending(a: Int): Unit = {
    val rollDEF = rollDice_wu()
    val receive = a - (rollDEF + defense)

    if (receive < 1) {
      val b = Hp - 1
      Hp_=(b)
    }
    else {
      if (receive > Hp) {
        Hp_=(0)
      }
      else {
        val b = Hp - receive
        Hp_=(b)
      }
    }
  }

  override def evading(a: Int): Unit = {
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

}
