package cl.uchile.dcc.citric
package model.traits

trait WildUnit extends Units{
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
