package cl.uchile.dcc.citric
package model.factories

import model.panels.Neutral

import cl.uchile.dcc.citric.model.traits.PanelFactory

/** Represents a neutral panels factory.
 *
 * A panel factory creates a neutral panel.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class NeutralFactory extends PanelFactory[Neutral]{

  /** create a new neutral panel.
   *
   * This function might be invoked at the creating
   * of the board of the game.
   *
   * */
  def createPanel(): Neutral = {
    new Neutral()
  }

}
