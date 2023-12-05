package cl.uchile.dcc.citric
package model.abstractclasses

import model.player.PlayerCharacter

import cl.uchile.dcc.citric.model.traits.Panel

import scala.collection.mutable.ArrayBuffer

/** Represents an Abstract single cell on a board, known as a Panel.
  *
  *
  * @author [[https://github.com/r8vnhill Ignacio Slater M.]]
  * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
  */
abstract class AbsPanel extends Panel{

  /** Array of the characters currently positioned on this panel.
    *
    * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
    * land on the same space.
    */
  val characters: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()

  /** An array of panels that are directly connected to this one.
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return a List of Panel instances that are adjacent or connected to this panel.
   */
  var nextPanels: ArrayBuffer[Panel] = new ArrayBuffer[Panel]()



  /** Adds a character to the list of characters currently on this panel.
    *
    * This might be invoked when a player moves to this panel or starts their turn on it.
    *
    * @param player The player character to add to this panel.
    */
  def addCharacter(player: PlayerCharacter): Unit = {
    if (characters.indexOf(player) == -1) {
      characters.addOne(player)
    }
  }

  /** Removes a character from the list of characters currently on this panel.
    *
    * This might be invoked when a player moves off this panel.
    *
    * @param player The player character to remove from this panel.
    */
  def removeCharacter(player: PlayerCharacter): Unit = {
    if (characters.indexOf(player) != -1) {
      val index: Int = characters.indexOf(player)
      characters.remove(index)
    }
  }

  /** Adds a panel to the list of nextPanels currently on this panel.
   *
   * This might be invoked when the map of the game is in construction.
   *
   * @param panel The panel to add to next this panel.
   */
  def addPanel(panel: Panel): Unit = {
    if (nextPanels.indexOf(panel) == -1) {
      nextPanels.addOne(panel)
    }
  }

  /** Removes a panel from the list of nextPanels currently on this panel.
   *
   * This might be invoked when the map of the game is in construction.
   *
   * @param panel The panel to remove from the next of this panel.
   */
  def removePanel(panel: Panel): Unit = {
    if (nextPanels.indexOf(panel) != -1){
      val index: Int = nextPanels.indexOf(panel)
      nextPanels.remove(index)
    }
  }



}
