package cl.uchile.dcc.citric
package model.wild

import cl.uchile.dcc.citric.model.abstractclasses.WildUnit
import cl.uchile.dcc.citric.model.player.PlayerCharacter
import exceptions.CannotAttack
import model.traits.Units

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

  /** when a Chicken defeats a player, wins the half of the rival's stars */
  def winStars(p: PlayerCharacter): Unit = {
    val a: Int = p.stars / 2
    val b: Int = stars + a
    stars_=(b)
  }

  /** methods when the battle ends */
  def defeated(u: PlayerCharacter): Unit = {
    u.win_against_Chicken(this)
    stars_=(0)
  }

  def win_against_PlayChar(u: PlayerCharacter): Unit = {
    winStars(u)
  }


  /** method that stars an attack from the Chicken to a PlayerCharacter */
  /**
  def attacking_to_PlayChar(u: PlayerCharacter): Unit = {
    the PlayerCharacter makes a decision between defend or evade the Chicken's attack
      u.defending_to_Chicken(this)
    or
      u.evading_to_Chicken(this)
  } */

}
