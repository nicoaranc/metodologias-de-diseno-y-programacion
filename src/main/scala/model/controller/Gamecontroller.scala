package cl.uchile.dcc.citric
package model.controller

import model.player.PlayerCharacter

import cl.uchile.dcc.citric.model.panels.home
import cl.uchile.dcc.citric.model.states.StartState
import cl.uchile.dcc.citric.model.traits.GameState

import scala.collection.mutable
import scala.util.Random

class Gamecontroller {

  var chapters: Int = 1

  var state: GameState = new StartState()

  private var players = List.empty[PlayerCharacter]

  private val turnsOrder = mutable.Queue.empty[PlayerCharacter]

  var currentPlayer: Option[PlayerCharacter] = None


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

  def setPlayer(): Unit = {
    /** POR IMPLEMENTAR*/
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

  def fight_decision(): Unit = {
    state.fight_decision()
  }

  def defend(): Unit = {
    state.defend()
  }

  def evade(): Unit = {
    state.evade()
  }

  def doEffect(): Unit = {
    state.doEffect()
  }

  def onAHomePanel(): Boolean = state.onAHomePanel()
  def onANeutralPanel(): Boolean = state.onANeutralPanel()
  def onABonusPanel(): Boolean = state.onABonusPanel()
  def onADropPanel(): Boolean = state.onADropPanel()
  def onAEncounterPanel(): Boolean = state.onAEncounterPanel()

}
