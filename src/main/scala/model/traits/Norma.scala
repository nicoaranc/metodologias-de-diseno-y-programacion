package cl.uchile.dcc.citric
package model.traits

/** Represents a level of the player during tha game.
 *
 * Each Norma have their owns goals to be reached (except the first one).
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

trait Norma {

  /** the stars goal of the norma */
  val stars_goal: Int

  /** the victories goal of the norma */
  val victories_goal: Int

  def normaSix(): Boolean
}
