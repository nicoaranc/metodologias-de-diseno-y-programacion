package cl.uchile.dcc.citric
package model.factories

import model.traits.PanelFactory

import cl.uchile.dcc.citric.model.panels.Bonus

/** Represents a bonus panels factory.
 *
 * A panel factory creates a bonus panel.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */


class BonusFactory extends PanelFactory[Bonus]{

  /** create a new bonus panel.
   *
   * This function might be invoked at the creating
   * of the board of the game.
   *
   * */
  def createPanel(): Bonus = {
    new Bonus()
  }

}
