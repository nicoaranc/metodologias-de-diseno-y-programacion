package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import model.wild.{RoboBall,Chicken,Seagull}
import cl.uchile.dcc.citric.model.abstractclasses.{Panel, WildUnit}
import scala.util.Random

import scala.collection.mutable.ArrayBuffer

/** Represents a encounter panel.
 *
 * A Encounter Panel gives a random Wild Unit to battle with the players.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class encounter  extends Panel{

  /** "characters" is the ArrayBuffer of the players that are on the Panel */
  val characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()

  /** "nextPanels" is the ArrayBuffer of the panels that they are next in
   * every direction of the panel */
  var nextPanels: ArrayBuffer[Panel] = new ArrayBuffer[Panel]()



  /** This method returns a Random Wild Unit to fight */
  def apply(): WildUnit = {
    val a: Random = new Random()
    val b: Int = a.nextInt(3) + 1
    if (b == 1){
      new RoboBall()
    }
    else if (b == 2){
      new Chicken()
    }
    else{
      new Seagull()
    }
  }
}
