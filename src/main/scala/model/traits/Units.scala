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

  def attacking(u: PlayerCharacter): Int

  def defending(a: Int): Unit

  def evading(a: Int): Unit
}
