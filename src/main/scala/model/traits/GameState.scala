package cl.uchile.dcc.citric
package model.traits

import model.controller.GameController
import model.player.PlayerCharacter

/** Represents a general GameState.
 *
 * Each GameState have their owns proper valid transitions,
 * and also (depends on the state) can participate of
 * the game's functionalities
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

trait GameState {

  /** The context is a GameController */
  val context: GameController

  /** appears when a Invalid Transition happens
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def error(): Unit

  /** event that make a transition from the PreGame state
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def startGame(): Unit

  /** event that make a transition from the Chapter state
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def playTurn(): Unit

  /** event that make a transition from the Chapter state
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def normaSixReached(): Unit

  /** event that make a transition from specific states
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def checkHp(): Unit

  /** event that make a transition from specific states
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def rollsDice(): Unit

  /** event that make a transition from the PlayerCanPlay state
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def starsForPlayer(): Unit

  /** event that make a transition from the OnAPanel state
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def checkPanel(): Unit

  /** event that make a transition from the DecisionToFight state
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def fight_decision(): Unit

  /** event that make a transition from the AppPanel state
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def doEffect(): Unit




}
