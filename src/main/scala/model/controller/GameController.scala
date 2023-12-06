package cl.uchile.dcc.citric
package model.controller

import model.player.PlayerCharacter

import cl.uchile.dcc.citric.model.board.Board
import cl.uchile.dcc.citric.model.events.NormaSixEvent
import cl.uchile.dcc.citric.model.norma.Norma6
import cl.uchile.dcc.citric.model.panels.Home
import cl.uchile.dcc.citric.model.states.PreGame
import cl.uchile.dcc.citric.model.traits.{GameState, Norma, Observer, Panel, Subject, Units}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class GameController extends Observer[NormaSixEvent]{

  /** the board of the game */
  var board: Option[Board] = None

  /** the finish state of the game */
  private var _finishedGame: Boolean = false

  /** the getter of the state of the game */
  def finishedGame: Boolean = _finishedGame

  /** the chapter of the game */
  var chapters: Int = 1

  /** the number of the turn of the chapter */
  var turns: Int = 0

  /** the current state of the game */
  var state: GameState = new PreGame(this)

  /** the array of the players of the game with the respective turn's order*/
  val players: ArrayBuffer[PlayerCharacter] = new ArrayBuffer[PlayerCharacter]()


  /** the current Player of the game */
  var currentPlayer: Option[PlayerCharacter] = None

  /** the current Panel of the game */
  var currentPanel: Option[Panel] = None

  /** the current Rival of the current player of the game */
  var currentRival: Option[PlayerCharacter] = None

  /** the winner of the game */
  private var _winner: Option[PlayerCharacter] = None

  /** getter of the winner of the game */
  def winner: Option[PlayerCharacter] = _winner


  /** sets the winner of the game
   *
   * this function might e invoked when the controller receive an
   * update of the norma of a player
   *
   * @param observable The player that reach the 6th Norma
   * @param value The notified event
   * */
  def update(observable: Subject[NormaSixEvent], value: NormaSixEvent): Unit = {
    _winner = currentPlayer
    _finishedGame = true
  }


  /** adds a player to the players array of the controller
   *
   * this function might e invoked when the game is setting
   * the players
   *
   * @param player The player to add

   * */
  def addPlayer(player: PlayerCharacter): Unit = {
    if (players.indexOf(player) == -1) {
      players.addOne(player)
    }

  }

  /** adds an Array of players to add to the players array of the controller, also with a random turn order
   *
   * this function might e invoked when the game is setting
   * the players
   *
   * @param playersArray The array of players to add
   *
   * */
  def setOrder(playersArray: ArrayBuffer[PlayerCharacter]): Unit = {
    for (a <- 1 to 4){
      val size: Int = playersArray.size
      val dice: Int = new Random().nextInt(size)
      val player: PlayerCharacter = playersArray(dice)
      addPlayer(player)
      playersArray.remove(dice)
    }
    currentPlayer = Some(players(0))
  }


  /** sets a new state to the controller
   *
   * this function might e invoked when a transition is done
   *
   * @param s The state to set
   *
   * */
  def setState(s: GameState): Unit = {
    state = s
  }

  /** sets a new Rival to the current Player
   *
   * this function might e invoked when a player lands on
   * an occupied panel
   *
   * */
  def setRival(): Unit = {
    var rivals: ArrayBuffer[PlayerCharacter] = currentPanel.get.characters
    val panel: Panel = currentPanel.get
    val position: Int = rivals.indexOf(currentPlayer.get)
    rivals.remove(position)
    val number_rivals: Int = rivals.size
    val roll: Int = new Random().nextInt(number_rivals)
    currentRival = Some(panel.characters(roll))
  }

  /** sets a new current panel
   *
   * this function might e invoked when a player is moving
   * on the board
   *
   * */
  def setPanel(): Unit = {
    val player: PlayerCharacter = currentPlayer.get
    val panel: Panel = currentPanel.get
    val number_path: Int = panel.nextPanels.size
    panel.removeCharacter(player)
    val rand: Random = new Random()
    val roll: Int = rand.nextInt(number_path)
    currentPanel = Some(panel.nextPanels(roll))
    currentPanel.get.addCharacter(player)
    player.panel = currentPanel
  }

  /** sets the new values to the currentPanel when leaves the RecoveryPhase
   *
   * this function might e invoked when a player leaves the RecoveryPhase
   *
   * */
  def playerLeaveRecovery(): Unit = {
    val player: PlayerCharacter = currentPlayer.get
    player.Recovery_=(false)
    player.Can_play_=(true)
  }

  /** If someone reach the 6th Norma, delegate to the state to
   * make a transition
   *
   * this function might be invoked when the controller delegates
   * to the state a transition
   *
   * */
  def normaSixReached(): Unit = {
    if (finishedGame){
      state.normaSixReached()
    }
  }

  /** Starts the game
   *
   * this function might be invoked when the controller delegates
   * to the state a transition
   *
   * */
  def startGame(): Unit = {
    state.startGame()
  }

  /** set the chapter and Turn's number of the game
   *
   * this function might be invoked when all player plays
   * in a chapter
   *
   * */
  def newChapter(): Unit = {
    if (turns == 4) {
      chapters += 1
      turns = 0
    }
  }

  /** set the Turn's number of the game
   *
   * this function might be invoked when a player starts his turn
   *
   * */
  def newTurn(): Unit = {
    turns += 1
  }


  /** delegates to the current state to make a transition
   *
   * this function might be invoked when the controller
   * wants to make a transition between states
   *
   * */
  def playTurn(): Unit = {
    state.playTurn()
  }

  /** delegates to the current state to make a transition
   *
   * this function might be invoked when the controller
   * wants to make a transition between states
   *
   * */
  def starsForPlayer(): Unit = {
    state.starsForPlayer()
  }

  /** delegates to the current state to make a transition
   *
   * this function might be invoked when the controller
   * wants to make a transition between states
   *
   * */
  def checkHp(): Unit = {
    state.checkHp()
  }

  /** delegates to the current state to make a transition
   *
   * this function might be invoked when the controller
   * wants to make a transition between states
   *
   * */
  def rollsDice(): Unit = {
    state.rollsDice()
  }

  /** delegates to the current state to make a transition
   *
   * this function might be invoked when the controller
   * wants to make a transition between states
   *
   * */
  def checkPanel(): Unit = {
    state.checkPanel()
  }

  /** delegates to the current state to make a transition
   *
   * this function might be invoked when the controller
   * wants to make a transition between states
   *
   * */
  def fight_decision(): Unit = {
    state.fight_decision()
  }


  /** delegates to the current state to make a transition
   *
   * this function might be invoked when the controller
   * wants to make a transition between states
   *
   * */
  def doEffect(): Unit = {
    state.doEffect()
  }

  /** set a new Current PLayer
   *
   * this function might be invoked when the current Player
   * ends his turn
   *
   * */
  def setPlayer(): Unit = {
    val player: PlayerCharacter = players(0)
    players.remove(0)
    players.addOne(player)
    currentPlayer = Some(players(0))
    currentPanel = currentPlayer.get.panel
  }


}
