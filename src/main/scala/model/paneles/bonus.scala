package cl.uchile.dcc.citric
package model.paneles
import model.PlayerCharacter
import model.Panel

import scala.collection.mutable.ArrayBuffer

class bonus extends Panel{

  val characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()

  var nextPanels: ArrayBuffer[Panel] = new ArrayBuffer[Panel]()

  def addCharacter(player: PlayerCharacter): Unit = {
    if (characters.indexOf(player) == -1) {
      characters.addOne(player)
    }
  }

  def removeCharacter(player: PlayerCharacter): Unit = {
    if (characters.indexOf(player) != -1) {
      val index: Int = characters.indexOf(player)
      characters.remove(index)
    }
  }


  def give_stars(player: PlayerCharacter): Unit = {
    val roll: Int = player.rollDice()
    val Norm: Int = player.norm
    val a = roll * Norm
    val b = roll * 3
    if (a <= b){
      player.stars += a
    }
    else{
      player.stars += b
    }
  }
}
