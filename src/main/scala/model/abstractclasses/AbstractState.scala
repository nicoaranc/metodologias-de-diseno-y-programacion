package cl.uchile.dcc.citric
package model.abstractclasses

import model.traits.GameState

import cl.uchile.dcc.citric.model.controller.Gamecontroller
import cl.uchile.dcc.citric.model.player.PlayerCharacter

abstract class AbstractState extends GameState{

  protected val context: Gamecontroller = new Gamecontroller()

  def onADropPanel(): Boolean = false

  def onAHomePanel(): Boolean = false

  def onAEncounterPanel(): Boolean = false

  def onABonusPanel(): Boolean = false

  def onANeutralPanel(): Boolean = false

  def error(): Unit = {
    throw new AssertionError("Wrong State")
  }

  def checkHp(): Unit = {
    this.error()
  }

  def rollsDice(): Unit = {
    this.error()
  }

  def starsForPlayer(): Unit = {
    this.error()
  }

  def checkPanel(): Unit = {
    this.error()
  }

  def fight_decision(): Unit = {
    this.error()
  }


  def doEffect(): Unit = {
    this.error()
  }

  def setState(state: GameState): Unit = {
    context.setState(state)
  }

}
