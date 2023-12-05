package cl.uchile.dcc.citric
package model.abstractclasses

import model.traits.{GameState, Units}

import cl.uchile.dcc.citric.exceptions.InvalidTransition
import cl.uchile.dcc.citric.model.controller.GameController
import cl.uchile.dcc.citric.model.player.PlayerCharacter

/** Represents an abstract GameState.
 *
 * Each GameState have their owns proper valid transitions,
 * but the original implementation throws an Invalid Transition
 * Exception that will be changed in specific state's classes
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

abstract class AbstractState (val context: GameController) extends GameState{

  /** sets the context's state */
  context.state = this

  /** throws an InvalidTransition Exception
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def error(): Unit = {
    throw new InvalidTransition("Invalid transition")
  }

  /** From the base of the state, this event throws an Exception
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def startGame(): Unit = {
    this.error()
  }

  /** From the base of the state, this event throws an Exception
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def playTurn(): Unit = {
    this.error()
  }

  /** From the base of the state, this event throws an Exception
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def normaSixReached(): Unit = {
    this.error()
  }

  /** From the base of the state, this event throws an Exception
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def checkHp(): Unit = {
    this.error()
  }

  /** From the base of the state, this event throws an Exception
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def rollsDice(): Unit = {
    this.error()
  }

  /** From the base of the state, this event throws an Exception
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def starsForPlayer(): Unit = {
    this.error()
  }

  /** From the base of the state, this event throws an Exception
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def checkPanel(): Unit = {
    this.error()
  }

  /** From the base of the state, this event throws an Exception
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def fight_decision(): Unit = {
    this.error()
  }

  /** From the base of the state, this event throws an Exception
   *
   * This function might be invoked when
   * a state transition happens
   *
   * */
  def doEffect(): Unit = {
    this.error()
  }

  /** sets a new State for the GameController
   *
   * This function might be invoked when
   * a state transition happens
   *
   * @param state The new state to set
   * */
  def setState(state: GameState): Unit = {
    context.setState(state)
  }

}