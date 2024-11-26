package cl.uchile.dcc.citric
package model.factories

import model.panels.Encounter

import cl.uchile.dcc.citric.model.traits.PanelFactory

/** Represents a encounter panels factory.
 *
 * A panel factory creates an encounter panel.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class EncounterFactory extends PanelFactory[Encounter]{

  /** create a new encounter panel.
   *
   * This function might be invoked at the creating
   * of the board of the game.
   *
   * */
  def createPanel(): Encounter = {
    new Encounter()
  }

}
