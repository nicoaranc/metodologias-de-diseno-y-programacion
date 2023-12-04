package cl.uchile.dcc.citric
package model.traits

import model.controller.GameController
import model.player.PlayerCharacter

trait GameState {

  val context: GameController

  def error(): Unit

  def startGame(): Unit

  def newChapter(): Unit

  def playTurn(): Unit

  def normaSixReached(): Unit

  def checkHp(): Unit

  def rollsDice(): Unit

  def starsForPlayer(): Unit

  def checkPanel(): Unit

  def fight_decision(): Unit

  def doEffect(): Unit

  def setState(state: GameState): Unit


}
