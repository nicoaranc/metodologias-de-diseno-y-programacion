package cl.uchile.dcc.citric
package model.factories

import model.panels.Drop

import cl.uchile.dcc.citric.model.traits.PanelFactory

/** Represents a drop panels factory.
 *
 * A panel factory creates a drop panel
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class DropFactory extends PanelFactory[Drop]{


  /** create a new drop panel.
   *
   * This function might be invoked at the creating
   * of the board of the game.
   *
   * */
  def createPanel(): Drop = {
    new Drop()
  }

}
