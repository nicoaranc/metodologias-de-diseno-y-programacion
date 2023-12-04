package cl.uchile.dcc.citric
package model.controller

import model.player.PlayerCharacter

import cl.uchile.dcc.citric.model.events.NormaSixEvent
import cl.uchile.dcc.citric.model.norma.Norma6
import cl.uchile.dcc.citric.model.panels.home
import cl.uchile.dcc.citric.model.states.PreGame
import cl.uchile.dcc.citric.model.traits.{GameState, Norma, Observer, Panel, Subject, Units}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class GameController extends Observer[NormaSixEvent]{

  private var finishedGame: Boolean = false

  var chapters: Int = 1

  var turns: Int = 0

  var state: GameState = new PreGame(this)

  private var players = List.empty[PlayerCharacter]

  private val turnsOrder = mutable.Queue.empty[PlayerCharacter]

  var panel: home = new home()

  var currentPlayer: Option[PlayerCharacter] = None

  var currentPanel: Option[Panel] = None

  var currentRival: Option[PlayerCharacter] = None

  private var _winner: Option[PlayerCharacter] = None

  def winner: Option[PlayerCharacter] = _winner


  def update(observable: Subject[NormaSixEvent], value: NormaSixEvent): Unit = {
    _winner = currentPlayer
  }


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

  def normaSixReached(): Unit = {
    if (finishedGame){
      state.normaSixReached()
    }
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

  def starsForPlayer(): Unit = {
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

  }

  def doEffect(): Unit = {
    state.doEffect()
  }



}
