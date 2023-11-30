package cl.uchile.dcc.citric
package model.traits

import model.controller.Gamecontroller
import model.player.PlayerCharacter

trait GameState {

  protected val context: Gamecontroller

  def error(): Unit

  def startGame(): Unit

  def newChapter(): Unit

  def playTurn(): Unit

  def normaSixReached(): Unit

  def checkHp(): Unit

  def rollsDice(): Unit

  def starsForPlayer(): Unit

  def checkPanel(): Unit

  def fight_decision(input: String): Unit

  def doEffect(): Unit

  def setState(state: GameState): Unit


}
