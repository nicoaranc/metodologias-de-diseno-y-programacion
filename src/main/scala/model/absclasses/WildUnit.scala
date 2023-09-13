package cl.uchile.dcc.citric
package model.absclasses
import model.traits.Units

import cl.uchile.dcc.citric.model.PlayerCharacter

abstract class WildUnit extends Units{
  var Hp: Int

  val maxHp: Int

  val attack: Int

  val defense: Int

  val evasion: Int

  var stars: Int

  def dead(): Boolean

  def winStars(player: PlayerCharacter): Unit
}
