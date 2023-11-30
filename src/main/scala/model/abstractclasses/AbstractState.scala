package cl.uchile.dcc.citric
package model.abstractclasses

import model.traits.{GameState, Units}

import cl.uchile.dcc.citric.model.controller.Gamecontroller
import cl.uchile.dcc.citric.model.player.PlayerCharacter

abstract class AbstractState extends GameState{

  protected val context: Gamecontroller = new Gamecontroller()



  def error(): Unit = {
    throw new AssertionError("Wrong State")
  }

  def startGame(): Unit = {
    this.error()
  }

  def newChapter(): Unit = {
    this.error()
  }

  def playTurn(): Unit = {
    this.error()
  }

  def normaSixReached(): Unit = {
    this.error()
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

  def fight_decision(input: String): Unit = {
    this.error()
  }


  def doEffect(): Unit = {
    this.error()
  }

  def setState(state: GameState): Unit = {
    context.setState(state)
  }

}
