package cl.uchile.dcc.citric
package model.controller

import model.player.PlayerCharacter

import cl.uchile.dcc.citric.model.panels.home
import cl.uchile.dcc.citric.model.states.{GameState, StartState}

import scala.collection.mutable
import scala.util.Random

class Gamecontroller {

  var state: GameState = new StartState(this)

  private var players = List.empty[PlayerCharacter]

  private val turnsOrder = mutable.Queue.empty[PlayerCharacter]

  private var selection: Option[PlayerCharacter] = None

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
}
