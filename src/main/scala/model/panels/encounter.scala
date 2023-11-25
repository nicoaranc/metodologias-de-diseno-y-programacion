package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import model.wild.{Chicken, RoboBall, Seagull}

import cl.uchile.dcc.citric.model.abstractclasses.{AbsPanel, WildUnit}
import cl.uchile.dcc.citric.model.traits.Units

import scala.util.Random
import scala.collection.mutable.ArrayBuffer

/** Represents a encounter panel.
 *
 * A Encounter Panel gives a random Wild Unit to battle with the players.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class encounter  extends AbsPanel{

  var w_unit: Units = _

  /** This method returns a Random Wild Unit to fight */
  def apply(p: PlayerCharacter): Unit = {
    val a: Random = new Random()
    val b: Int = a.nextInt(3) + 1
    if (b == 1){
      w_unit = new RoboBall()
      p.attacking_to(w_unit)
    }
    else if (b == 2){
      w_unit = new Chicken()
      p.attacking_to(w_unit)
    }
    else{
      w_unit = new Seagull()
      p.attacking_to(w_unit)
    }
  }
}
