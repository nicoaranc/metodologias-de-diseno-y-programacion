package cl.uchile.dcc.citric
package model.abstractclasses

import model.traits.Norma

/** Represents an Abstract norma.
 *
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */
abstract class AbstractNorma extends Norma{

  /** Checks if the norma is the 6th Norma
   *
   * This might be invoked when a player reach a new Norma level.
   *
   */
  def normaSix(): Boolean = {
    false
  }

}
