package cl.uchile.dcc.citric
package model.wild

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import cl.uchile.dcc.citric.model.traits.WildUnit

class Chicken extends WildUnit{

  /** Chicken stats */

  val maxHp: Int = 3

  private var _Hp: Int = maxHp
  def Hp: Int = _Hp
  def Hp_=(NewHp: Int): Unit = {
    _Hp = NewHp
  }

  val attack: Int = -1

  val defense: Int = -1

  val evasion: Int = 1

  private var _stars: Int = 0
  def stars: Int = _stars
  def stars_=(NewStars: Int): Unit = {
    _stars = NewStars
  }

  var alive = true


}
