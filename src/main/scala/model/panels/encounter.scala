package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.player.PlayerCharacter
import model.wild.{Chicken, RoboBall, Seagull}

import cl.uchile.dcc.citric.model.abstractclasses.{AbsPanel, WildUnit}
import cl.uchile.dcc.citric.model.traits.Units

import scala.Some
import scala.util.Random
import scala.collection.mutable.ArrayBuffer

/** Represents a encounter panel.
 *
 * A Encounter Panel gives a random Wild Unit to battle with the players.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class Encounter extends AbsPanel{

  var chicken: Option[Chicken] = None
  var seagull: Option[Seagull] = None
  var roboBall: Option[RoboBall] = None

  private def seagullFights(p: PlayerCharacter): Unit = {
    p.attacking_to(seagull.get)
    if (seagull.get.dead()) {
      p.win_against_Seagull(seagull.get)
      seagull = None
    }
    else {
      seagull.get.attacking_to_PlayChar(p)
      if (p.Hp == 0){
        seagull.get.win_against_PlayChar(p)
      }
    }
  }

  private def chickenFights(p: PlayerCharacter): Unit = {
    p.attacking_to(chicken.get)
    if (chicken.get.dead()) {
      p.win_against_Chicken(chicken.get)
      chicken = None
    }
    else {
      chicken.get.attacking_to_PlayChar(p)
      if (p.Hp == 0) {
        chicken.get.win_against_PlayChar(p)
      }
    }
  }

  private def roboBallFights(p: PlayerCharacter): Unit = {
    p.attacking_to(roboBall.get)
    if (roboBall.get.dead()) {
      p.win_against_RoboBall(roboBall.get)
      roboBall = None
    }
    else {
      roboBall.get.attacking_to_PlayChar(p)
      if (p.Hp == 0) {
        roboBall.get.win_against_PlayChar(p)
      }
    }
  }


  /** This method returns a Random Wild Unit to fight */
  def apply(p: PlayerCharacter): Unit = {
    if (chicken.isEmpty && seagull.isEmpty && roboBall.isEmpty){
      val a: Random = new Random()
      val b: Int = a.nextInt(3) + 1
      if (b == 1) {
        roboBall = Some(new RoboBall())
        roboBallFights(p)
      }
      else if (b == 2) {
        chicken = Some(new Chicken())
        chickenFights(p)
      }
      else {
        seagull = Some(new Seagull())
        seagullFights(p)
      }
    }
    else if (chicken.isDefined){
      chickenFights(p)
    }
    else if (roboBall.isDefined){
      roboBallFights(p)
    }
    else if (seagull.isDefined){
      seagullFights(p)
    }
  }
}



