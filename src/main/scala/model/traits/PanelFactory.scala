package cl.uchile.dcc.citric
package model.traits

/** Represents a general panels factory.
 *
 * A panel factory creates a panel
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

trait PanelFactory[+T <: Panel] {

  /** create a new panel
   *
   * This function might be invoked at the creating
   * of the board of the game
   *
   * */
  def createPanel(): T

}
