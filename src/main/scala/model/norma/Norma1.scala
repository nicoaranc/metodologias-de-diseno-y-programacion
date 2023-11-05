package cl.uchile.dcc.citric
package model.norma

import model.traits.Norma

/** Represents the 1st Norma.
 *
 * The 1st Norma don't have any goals, because is the current Norma of
 * teh new player at the beginning of the game.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class Norma1 extends Norma{

  /** The Norma1 is the initial level of the player,
   * this norma doesn't have a stars or victories goal*/
  val stars_goal = 0

  val victories_goal = 0
}
