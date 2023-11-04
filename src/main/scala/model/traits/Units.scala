package cl.uchile.dcc.citric
package model.traits

import model.player.PlayerCharacter

trait Units {
  var Hp: Int

  val maxHp: Int

  val attack: Int

  val defense: Int

  val evasion: Int

  var stars: Int

  def winStars(p: PlayerCharacter): Unit

  /**
  def can_attack(u: PlayerCharacter): Int

  def attacking(): Unit

  def defending(a: Int): Unit

  def evading(a: Int): Unit
   */

  def attacking(): Int

  def defending(a: Int) : Unit

  def evading(a: Int) : Unit

  def defending_to_PlayChar(u: PlayerCharacter): Unit

  def evading_to_PlayChar(u: PlayerCharacter): Unit


}
