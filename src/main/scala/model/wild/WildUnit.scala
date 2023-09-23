package cl.uchile.dcc.citric
package model.wild

import model.player.PlayerCharacter
import model.traits.Units

abstract class WildUnit extends Units{
  var Hp: Int

  val maxHp: Int

  val attack: Int

  val defense: Int

  val evasion: Int

  var stars: Int

  def dead(): Boolean = {
    if (Hp == 0){
      return true
    }
    else{
      return false
    }
  }

}
