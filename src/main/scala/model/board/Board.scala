package cl.uchile.dcc.citric
package model.board

import model.traits.Panel

import cl.uchile.dcc.citric.model.factories.{BonusFactory, DropFactory, EncounterFactory, HomeFactory, NeutralFactory}
import cl.uchile.dcc.citric.model.panels.{Bonus, Drop, Encounter, Home, Neutral}

import scala.collection.mutable.ArrayBuffer

/** Represents the Board of the game.
 *
 * The Board has many differents panels
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class Board {

  /** Array of the board's panels */
  val PanelsArray: ArrayBuffer[Panel] = new ArrayBuffer[Panel]()

  /** The factory of neutral panels*/
  private val neutralFactory: NeutralFactory = new NeutralFactory()

  /** The factory of drop panels*/
  private val dropFactory: DropFactory = new DropFactory()

  /** The factory of home panels*/
  private val homeFactory: HomeFactory = new HomeFactory()

  /** The factory of bonus panels*/
  private val bonusFactory: BonusFactory = new BonusFactory()

  /** The factory of encounter panels*/
  private val encounterFactory: EncounterFactory = new EncounterFactory()

  /** add a neutral panel to the board
   *
   * This function might be invoked at the creation of the board
   *
   * */
  def addNeutral(): Neutral = {
    val neutral: Neutral = neutralFactory.createPanel()
    PanelsArray.addOne(neutral)
    neutral
  }

  /** add a bonus panel to the board
   *
   * This function might be invoked at the creation of the board
   *
   * */
  def addBonus(): Bonus = {
    val bonus: Bonus = bonusFactory.createPanel()
    PanelsArray.addOne(bonus)
    bonus
  }

  /** add a home panel to the board
   *
   * This function might be invoked at the creation of the board
   *
   * */
  def addHome(): Home = {
    val home: Home = homeFactory.createPanel()
    PanelsArray.addOne(home)
    home
  }

  /** add a encounter panel to the board
   *
   * This function might be invoked at the creation of the board
   *
   * */
  def addEncounter(): Encounter = {
    val encounter: Encounter = encounterFactory.createPanel()
    PanelsArray.addOne(encounter)
    encounter
  }

  /** add a drop panel to the board
   *
   * This function might be invoked at the creation of the board
   *
   * */
  def addDrop(): Drop = {
    val drop: Drop = dropFactory.createPanel()
    PanelsArray.addOne(drop)
    drop
  }

  /** creates a the base of a 3x3 "Square" Board
   *
   * This function might be invoked at the creation of the board
   *
   * */
  def construction(): Unit = {
    val panel1: Home = addHome()
    val panel2: Home = addHome()
    val panel3: Home = addHome()
    val panel4: Home = addHome()
    val panel5: Drop = addDrop()
    val panel6: Bonus = addBonus()
    val panel7: Encounter = addEncounter()
    val panel8: Neutral = addNeutral()
    val panel9: Neutral = addNeutral()
    panel1.addPanel(panel5)
    panel1.addPanel(panel9)
    panel2.addPanel(panel9)
    panel2.addPanel(panel8)
    panel9.addPanel(panel1)
    panel9.addPanel(panel2)
    panel9.addPanel(panel7)
    panel5.addPanel(panel1)
    panel5.addPanel(panel3)
    panel5.addPanel(panel7)
    panel3.addPanel(panel5)
    panel3.addPanel(panel6)
    panel6.addPanel(panel3)
    panel6.addPanel(panel4)
    panel6.addPanel(panel7)
    panel4.addPanel(panel6)
    panel4.addPanel(panel8)
    panel8.addPanel(panel2)
    panel8.addPanel(panel4)
    panel8.addPanel(panel7)
    panel7.addPanel(panel5)
    panel7.addPanel(panel6)
    panel7.addPanel(panel8)
    panel7.addPanel(panel9)
  }

}
