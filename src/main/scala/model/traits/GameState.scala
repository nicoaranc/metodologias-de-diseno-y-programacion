package cl.uchile.dcc.citric
package model.traits

import model.controller.Gamecontroller
import model.player.PlayerCharacter

trait GameState {

  protected val context: Gamecontroller

  def onAHomePanel(): Boolean

  def onANeutralPanel(): Boolean

  def onADropPanel(): Boolean

  def onAEncounterPanel(): Boolean

  def onABonusPanel(): Boolean

  def error(): Unit

  def checkHp(u: Units): Unit

  def rollsDice(): Unit

  def starsForPlayer(): Unit

  def checkPanel(): Unit

  def fight_decision(input: String): Unit

  def doEffect(): Unit

  def setState(state: GameState): Unit


}
