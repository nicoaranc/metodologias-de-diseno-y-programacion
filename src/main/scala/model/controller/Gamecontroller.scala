package cl.uchile.dcc.citric
package model.controller

import model.player.PlayerCharacter

import cl.uchile.dcc.citric.model.panels.home
import cl.uchile.dcc.citric.model.states.PreGame
import cl.uchile.dcc.citric.model.traits.{GameState, Panel, Units}

import scala.collection.mutable
import scala.util.Random

class Gamecontroller {

  var chapters: Int = 1

  var state: GameState = new PreGame()

  private var players = List.empty[PlayerCharacter]

  private val turnsOrder = mutable.Queue.empty[PlayerCharacter]

  var currentPlayer: Option[PlayerCharacter] = None

  var currentPanel: Option[Panel] = None

  var currentRival: Option[PlayerCharacter] = None


  def addPlayer(name: String, maxHp: Int, attack: Int, defense: Int,
                evasion: Int, randomNumberGenerator: Random, panelOwned: home): Unit = {
    new PlayerCharacter(name, maxHp, attack, defense, evasion, randomNumberGenerator, panelOwned) :: players
  }

  def StartGame(player: Seq[(String, Int, Int, Int, Int, Random, home)]) = {
    for ((name, maxHp, attack, defense, evasion, randomNumberGenerator, panelOwned) <- player){
      addPlayer(name, maxHp, attack, defense, evasion, randomNumberGenerator, panelOwned)
    }
  }

  def setState(s: GameState): Unit = {
    state = s
  }


  def startGame(): Unit = {
    state.startGame()
  }

  def newChapter(): Unit = {
    state.newChapter()
  }

  def playTurn(): Unit = {
    state.playTurn()
  }

  def checkHp(): Unit = {
    state.checkHp()
  }

  def rollsDice(): Unit = {
    state.rollsDice()
  }

  def checkPanel(): Unit = {
    state.checkPanel()
  }

  def fight_decision(input: String): Unit = {
    state.fight_decision(input)
  }

  def setPlayer(): Unit = {

  }

  def doEffect(): Unit = {
    state.doEffect()
  }



  def rival(opp: PlayerCharacter): Unit = {
    opp
  }

}
