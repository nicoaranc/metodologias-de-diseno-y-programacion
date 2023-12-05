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
   * This function might be invoked at the creating of the board
   *
   * */
  def addNeutral(): Unit = {
    val neutral: Neutral = neutralFactory.createPanel()
    PanelsArray.addOne(neutral)
  }

  /** add a bonus panel to the board
   *
   * This function might be invoked at the creating of the board
   *
   * */
  def addBonus(): Unit = {
    val bonus: Bonus = bonusFactory.createPanel()
    PanelsArray.addOne(bonus)
  }

  /** add a home panel to the board
   *
   * This function might be invoked at the creating of the board
   *
   * */
  def addHome(): Unit = {
    val home: Home = homeFactory.createPanel()
    PanelsArray.addOne(home)
  }

  /** add a encounter panel to the board
   *
   * This function might be invoked at the creating of the board
   *
   * */
  def addEncounter(): Unit = {
    val encounter: Encounter = encounterFactory.createPanel()
    PanelsArray.addOne(encounter)
  }

  /** add a drop panel to the board
   *
   * This function might be invoked at the creating of the board
   *
   * */
  def addDrop(): Unit = {
    val drop: Drop = dropFactory.createPanel()
    PanelsArray.addOne(drop)
  }

}
