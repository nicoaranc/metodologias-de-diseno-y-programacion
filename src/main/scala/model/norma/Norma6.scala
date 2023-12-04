package cl.uchile.dcc.citric
package model.norma

import model.traits.Norma

import cl.uchile.dcc.citric.model.abstractclasses.AbstractNorma

/** Represents the 6th Norma.
 *
 * The 6th Norma have their own goals to be reached.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */
class Norma6 extends AbstractNorma{

  /** stars goal of the Norma to reach */
  val stars_goal = 200

  /** stars goal of the Norma to reach */
  val victories_goal = 14

  override def normaSix(): Boolean = {
    true
  }
}
