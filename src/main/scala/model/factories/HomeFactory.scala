package cl.uchile.dcc.citric
package model.factories

import model.traits.PanelFactory

import cl.uchile.dcc.citric.model.panels.Home

/** Represents a home panels factory.
 *
 * A panel factory creates a home panel.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class HomeFactory extends PanelFactory[Home]{

  /** create a new home panel.
   *
   * This function might be invoked at the creating
   * of the board of the game.
   *
   * */
  def createPanel(): Home = {
    new Home()
  }

}
