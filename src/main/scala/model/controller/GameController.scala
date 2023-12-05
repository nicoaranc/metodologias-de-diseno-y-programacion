package cl.uchile.dcc.citric
package model.controller

import model.player.PlayerCharacter

import cl.uchile.dcc.citric.model.events.NormaSixEvent
import cl.uchile.dcc.citric.model.norma.Norma6
import cl.uchile.dcc.citric.model.panels.Home
import cl.uchile.dcc.citric.model.states.PreGame
import cl.uchile.dcc.citric.model.traits.{GameState, Norma, Observer, Panel, Subject, Units}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class GameController extends Observer[NormaSixEvent]{

  private var _finishedGame: Boolean = false

  def finishedGame: Boolean = _finishedGame

  var chapters: Int = 1

  var turns: Int = 0

  var state: GameState = new PreGame(this)

  private var players: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()

  private val turnsOrder = mutable.Queue.empty[PlayerCharacter]

  var panel: Home = new Home()

  var currentPlayer: Option[PlayerCharacter] = None

  var currentPanel: Option[Panel] = None

  var currentRival: Option[PlayerCharacter] = None

  private var _winner: Option[PlayerCharacter] = None

  def winner: Option[PlayerCharacter] = _winner


  def update(observable: Subject[NormaSixEvent], value: NormaSixEvent): Unit = {
    _winner = currentPlayer
    _finishedGame = true
  }


  def addPlayer(player: PlayerCharacter): Unit = {
    if (players.indexOf(player) == -1) {
      players.addOne(player)
    }

  }


  def setState(s: GameState): Unit = {
    state = s
  }

  def setRival(): Unit = {
    var rivals: ArrayBuffer[PlayerCharacter] = currentPanel.get.characters
    val panel: Panel = currentPanel.get
    val position: Int = rivals.indexOf(currentPlayer.get)
    rivals.remove(position)
    val number_rivals: Int = rivals.size
    val roll: Int = new Random().nextInt(number_rivals)
    currentRival = Some(panel.characters(roll))
  }

  def setPanel(): Unit = {
    val player: PlayerCharacter = currentPlayer.get
    val panel: Panel = currentPanel.get
    val number_path: Int = panel.nextPanels.size
    panel.removeCharacter(player)
    val rand: Random = new Random()
    val roll: Int = rand.nextInt(number_path)
    currentPanel = Some(panel.nextPanels(roll))
    currentPanel.get.addCharacter(player)
  }

  def playerLeaveRecovery(): Unit = {
    val player: PlayerCharacter = currentPlayer.get
    player.Recovery_=(false)
    player.Can_play_=(true)
  }

  def normaSixReached(): Unit = {
    if (finishedGame){
      state.normaSixReached()
    }
  }

  def startGame(): Unit = {
    state.startGame()
  }

  def newChapter(): Unit = {
    if (turns == 4) {
      chapters += 1
      turns = 0
    }
  }

  def newTurn(): Unit = {
    turns += 1
  }

  def playTurn(): Unit = {
    state.playTurn()
  }

  def starsForPlayer(): Unit = {
    val player: PlayerCharacter = currentPlayer.get
    val playerStars: Int = player.stars
    val starsGiven: Int = (chapters/5) + 1
    player.stars_=(playerStars + starsGiven)
    state.starsForPlayer()
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

  def setPlayer(): Unit = {
    val player: PlayerCharacter = players(0)
    players.remove(0)
    players.addOne(player)
    currentPlayer = Some(players(0))
  }

  def doEffect(): Unit = {
    state.doEffect()
  }



}
