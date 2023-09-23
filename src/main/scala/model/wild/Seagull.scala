package cl.uchile.dcc.citric
package model.wild

import cl.uchile.dcc.citric.model.player.PlayerCharacter

class Seagull extends WildUnit {

  val maxHp: Int = 3

  var Hp: Int = maxHp

  val attack: Int = 1

  val defense: Int = -1

  val evasion: Int = -1

  var stars: Int = 0



  def winStars(player: PlayerCharacter): Unit = {
    stars += (player.stars) / 2
  }
}
