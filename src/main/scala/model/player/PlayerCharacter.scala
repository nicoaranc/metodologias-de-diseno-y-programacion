package cl.uchile.dcc.citric
package model.player
import model.wild.{Chicken, RoboBall, Seagull}
import model.norma.{Norma1, Norma2, Norma3, Norma4, Norma5, Norma6}
import model.traits.{GameState, Norma, Observer, Panel, Subject, Units}
import model.panels.Home
import exceptions.CannotAttack

import cl.uchile.dcc.citric.model.abstractclasses.AbstractSubject
import cl.uchile.dcc.citric.model.controller.GameController
import cl.uchile.dcc.citric.model.events.NormaSixEvent
import cl.uchile.dcc.citric.model.states.PlayerTurn

import scala.util.Random
import scala.collection.mutable.ArrayBuffer

/** The `PlayerCharacter` class represents a character or avatar in the game, encapsulating
  * several attributes such as health points, attack strength, defense capability,
  * and evasion skills. Each player has a unique name, and throughout the game,
  * players can collect stars, roll dice, and progress in levels known as 'norma'.
  * This class not only maintains the state of a player but also provides methods
  * to modify and interact with these attributes.
  *
  * For instance, players can:
 *
  * - Increase or decrease their star count.
 *
  * - Roll a dice, a common action in many board games.
 *
  * - Advance their norma level.
  *
  * Furthermore, the `Player` class has a utility for generating random numbers,
  * which is primarily used for simulating dice rolls. By default, this utility is
  * an instance of the `Random` class but can be replaced if different random
  * generation behaviors are desired.
  *
  * @param name The name of the player. This is an identifier and should be unique.
  * @param maxHp The maximum health points a player can have. It represents the player's endurance.
  * @param attack The player's capability to deal damage to opponents.
  * @param defense The player's capability to resist or mitigate damage from opponents.
  * @param evasion The player's skill to completely avoid certain attacks.
  * @param randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
  *                              instance.
  * @param panelOwned The player's Home Panel.
  *
  * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
  */
class PlayerCharacter(val name: String,
              val maxHp: Int,
              val attack: Int,
              val defense: Int,
              val evasion: Int,
              val randomNumberGenerator: Random = new Random(),
              val panelOwned: Home) extends AbstractSubject[NormaSixEvent] with Units {


  /** instances of each Norma,
   * specifies each possible Norma to reach
   * */
  private val n1: Norma = new Norma1()
  private val n2: Norma = new Norma2()
  private val n3: Norma = new Norma3()
  private val n4: Norma = new Norma4()
  private val n5: Norma = new Norma5()
  private val n6: Norma = new Norma6()

  /** current Panel of the player */
  var panel: Option[Panel] = None

  /** current Hp of the player, at the beginning of the game is the maxHp */
  private var _Hp: Int = maxHp

  /** Getter of the Hp of the player */
  def Hp: Int = _Hp

  /** Setter of the Hp of the player.
   *
   * This function might be invoked in a battle.
   *
   * @param NewHp The new Hit Points of the player.
   */
  def Hp_=(NewHp: Int): Unit = {
    if (NewHp <= maxHp && NewHp >= 0){
      _Hp = NewHp
    }
  }

  /** current stars of the player, at the beginning of the game is 0 */
  private var _stars: Int = 0

  /** Getter of the stars of the player */
  def stars: Int = _stars

  /** Setter of the stars of the player.
   *
   * This function might be invoked when a battle finishes, the player is on a
   * bonus or drop panel.
   *
   * @param NewStars The new stars of the player.
   */
  def stars_=(NewStars: Int): Unit = {
    if (NewStars >= 0){
      _stars = NewStars
    }
  }

  /** current Norma of the player, at the beginning of the game is 1 */
  private var _norma: Norma = n1

  /** Getter of the Norma of the player */
  def norma: Norma = _norma

  /** Setter of the Norma of the player.
   *
   * This function might be invoked in the Norma Check.
   *
   * @param NewNorma The new Norma of the player.
   */
  def norma_=(NewNorma: Norma): Unit = {
    _norma = NewNorma
  }

  private var _norma_id: Int = 1

  /** Getter of the Norma Id of the player */
  def norma_id: Int = _norma_id

  /** Setter of the Norma Id of the player.
   *
   * This function might be invoked in the Norma Check.
   *
   * @param NewNormaId The new Norma Id of the player.
   */
  def norma_id_=(NewNormaId: Int): Unit = {
    _norma_id = NewNormaId
  }
  /** current victories of the player, at the beginning of the game is 0 */
  private var _victories: Int = 0

  /** Getter of the victories of the player */
  def victories: Int = _victories

  /** Setter of the victories of the player.
   *
   * This function might be invoked when a player defeats an unit.
   *
   * @param NewVictories The new victories count of the player.
   */
  def victories_=(NewVictories: Int): Unit = {
    if (NewVictories > victories){
      _victories = NewVictories
    }
  }

  /** current Recovery status */
  private var _Recovery: Boolean = false

  /** Getter of the Recovery state of the player */
  def Recovery: Boolean = _Recovery

  /** Setter of the Recovery state of the player.
   *
   * This function might be invoked when the player is defeated.
   *
   * @param NewRecovery The new Recovery state of the player.
   */
  def Recovery_=(NewRecovery: Boolean): Unit = {
    _Recovery = NewRecovery
  }

  /** current state of playing */
  private var _Can_play: Boolean = true

  /** Getter of the Playable state of the player */
  def Can_play: Boolean = _Can_play

  /** Setter of the Playable state of the player.
   *
   * This function might be invoked when the player is defeated.
   *
   * @param NewCanPlay The new Playable state of the player.
   */
  def Can_play_=(NewCanPlay: Boolean): Unit = {
    _Can_play = NewCanPlay
  }

  def dead: Boolean = {
    !Can_play
  }


  /** Array that contains all the instances of each Norma */
  val NormaArray: ArrayBuffer[Norma] = new ArrayBuffer[Norma]()
  NormaArray.addOne(n1)
  NormaArray.addOne(n2)
  NormaArray.addOne(n3)
  NormaArray.addOne(n4)
  NormaArray.addOne(n5)
  NormaArray.addOne(n6)

  /** the goal to reach the next level of Norma */
  private var _goal: Int = 0

  /** Getter of the goal of the player */
  def goal: Int = _goal

  /** Setter of the goal of the player.
   *
   * This function might be invoked in the Norma Clear.
   *
   * @param NewGoal The new goal of the player.
   */
  def goal_=(NewGoal: Int): Unit = {
    _goal = NewGoal
  }

  /** the kind of goal of the player*/
  private var _kind_goal: String = ""

  /** Getter of the kind of goal of the player */
  def kind_goal: String = _kind_goal

  /** Setter of the kind of goal of the player.
   *
   * This function might be invoked in the Norma Clear.
   *
   * @param NewKindGoal The new kind of goal of the player.
   */
  def kind_goal_=(NewKindGoal: String): Unit = {
    _kind_goal = NewKindGoal
  }


  /** the number of the chapter when the player enters to the RecoveryPhase */
  var recoveryChapter: Int = 0


  /** Rolls a dice and returns a random number between 1 to 6.
   *
   * This function might be invoked in combat, when a player is
   * on a drop or bonus panel.
   *
   */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }


  /** Sets a new goal for the player.
   *
   * This function might be invoked when the NormaCheck is done
   *
   */
  def setGoal(): Unit = {
    val roll: Int = new Random().nextInt(2) + 1
    if (roll == 1){
      val a: Int = NormaArray(norma_id).stars_goal
      kind_goal_=("stars")
      goal_=(a)
    }
    else{
      val a: Int = NormaArray(norma_id).victories_goal
      kind_goal_=("victories")
      goal_=(a)
    }
  }


  /** checks if the player can stop in the Home panel.
   *
   * This function might be invoked when the player
   * passes through a Home panel.
   *
   * @param panel The home panel to check.
   */
  def canStop(panel: Panel): Boolean = {
    if (panelOwned == panel){
      return true
    }
    else{
      return false
    }
  }

  /** gives two victories ot the player's victories count.
   *
   * This function might be invoked when the player defeats another player.
   *
   * @param u The player defeated by the winner of the battle.
   */
  private def victories_perBattle(u: PlayerCharacter): Unit = {
    val a: Int = victories + 2
    victories_=(a)
  }


  /** drops the half of stars from the player.
   *
   * This function might be invoked when the player is defeated.
   *
   * @param u The opponent that defeated the player.
   */
  private def dropStars_battle(u: Units): Unit = {
    val a: Int = stars - stars/2
    stars_=(a)
  }

  /** give stars to the player.
   *
   * This function might be invoked when the player wins
   * a battle against another player.
   *
   * @param u The player defeated.
   */
  def winStars(u: PlayerCharacter): Unit = {
    val a: Int = stars + u.stars/2
    stars_=(a)
  }

  /** give stars to the player.
   *
   * This function might be invoked when the player wins
   * a battle against a Chicken.
   *
   * @param u The Chicken defeated.
   */
  private def winStars_battle(u: Chicken): Unit = {
    val a: Int = stars + u.stars + 3
    stars_=(a)
  }

  /** give stars to the player.
   *
   * This function might be invoked when the player wins
   * a battle against a RoboBall.
   *
   * @param u The RoboBall defeated.
   */
  private def winStars_battle(u: RoboBall): Unit = {
    val a: Int = stars + u.stars + 2
    stars_=(a)
  }

  /** give stars to the player.
   *
   * This function might be invoked when the player wins
   * a battle against a Seagull.
   *
   * @param u The Seagull defeated.
   */
  private def winStars_battle(u: Seagull): Unit = {
    val a: Int = stars + u.stars + 2
    stars_=(a)
  }

  /** makes the exchange of stars and sets the new states of the player when is defeated.
   *
   * This function might be invoked when the battle ends.
   *
   * @param u The winner Unit.
   */
  def defeated(u: Units): Unit = {
    u.win_against_PlayChar(this)
    dropStars_battle(u)
    Can_play_=(false)
  }

  /** gives stars and victories to the player.
   *
   * This function might be invoked when the battle ends.
   *
   * @param u The player defeated.
   */
  def win_against_PlayChar(u: PlayerCharacter): Unit = {
    victories_perBattle(u)
    winStars(u)
  }

  /** gives stars and victories to the player.
   *
   * This function might be invoked when the battle ends.
   *
   * @param u The Chicken defeated.
   */
  def win_against_Chicken(u: Chicken): Unit = {
    val a: Int = victories + 1
    victories_=(a)
    winStars_battle(u)
  }

  /** gives stars and victories to the player.
   *
   * This function might be invoked when the battle ends.
   *
   * @param u The RoboBall defeated.
   */
  def win_against_RoboBall(u: RoboBall): Unit = {
    val a: Int = victories + 1
    victories_=(a)
    winStars_battle(u)
  }

  /** gives stars and victories to the player.
   *
   * This function might be invoked when the battle ends.
   *
   * @param u The Seagull defeated.
   */
  def win_against_Seagull(u: Seagull): Unit = {
    val a: Int = victories + 1
    victories_=(a)
    winStars_battle(u)
  }

  /** Makes the attack, return the attack points.
   *
   * This function might be invoked during the battle.
   *
   */
  def attacking(): Int = {
    val rollATK = rollDice()
    val aux = rollATK + attack
    if (aux >= 0) {
      return aux
    }
    else {
      return 0
    }
  }

  /** Makes the defense of the player.
   *
   * This function might be invoked during the battle.
   *
   * @param a The attack points to defend.
   */
  def defending(a: Int): Unit = {
    val rollDEF = rollDice()
    val receive = a - (rollDEF + defense)
    if (receive < 1) {
      val b = Hp - 1
      Hp_=(b)
    }
    else {
      if (receive >= Hp) {
        Hp_=(0)
      }
      else {
        val b = Hp - receive
        Hp_=(b)
      }
    }
  }

  /** Makes the evasion of the player.
   *
   * This function might be invoked during the battle.
   *
   * @param a The attack points to evade.
   */
  def evading(a: Int): Unit = {
    val rollEVA = rollDice()
    val aux = rollEVA + evasion

    if (aux > a) {
      return
    }
    else {
      if (a > Hp) {
        Hp_=(0)
      }
      else {
        val b = Hp - a
        Hp_=(b)
      }
    }
  }

  /** method that stars an attack to other Unit */

  def attacking_to(u: Units): Unit = {
    val roll: Int = new Random().nextInt(2) + 1
    if (roll == 1){
      u.defending_to_PlayChar(this)
    }
    else{
      u.evading_to_PlayChar(this)
    }

  }

  /** Throws an Exception if the fight isn't possible */
  private def impossibleToFight(u: Units): Unit = {
    if (u.dead()) {
      throw new CannotAttack("Current player can't attack")
    }
    else if (!Can_play){
      throw new CannotAttack("Rival is in Recovery phase")
    }
  }


  /** Starts the defense of the player.
   *
   * This function might be invoked when the battle starts.
   *
   * @param u The attacking player.
   */
  def defending_to_PlayChar(u: PlayerCharacter): Unit = {
    if (Can_play && u.Can_play) {
      val atk: Int = u.attacking()
      defending(atk)
    }
    else {
      impossibleToFight(u)
    }
  }

  /** makes the defense of the player.
   *
   * This function might be invoked when the battle starts.
   *
   * @param u The attacking Unit (wildUnit).
   */
  private def defending_to(u: Units): Unit = {
    if (Can_play && !u.dead()) {
      val atk: Int = u.attacking()
      defending(atk)
    }
    else {
      impossibleToFight(u)
    }
  }

  /** Starts the defense of the player.
   *
   * This function might be invoked when the battle starts.
   *
   * @param u The attacking Chicken.
   */
  def defending_to_Chicken(u: Chicken): Unit = {
    defending_to(u)
  }

  /** Starts the defense of the player.
   *
   * This function might be invoked when the battle starts.
   *
   * @param u The attacking RoboBall.
   */
  def defending_to_RoboBall(u: RoboBall): Unit = {
    defending_to(u)
  }

  /** Starts the defense of the player.
   *
   * This function might be invoked when the battle starts.
   *
   * @param u The attacking Seagull.
   */
  def defending_to_Seagull(u: Seagull): Unit = {
    defending_to(u)
  }

  /** Starts the evasion of the player.
   *
   * This function might be invoked when the battle starts.
   *
   * @param u The attacking player.
   */
  def evading_to_PlayChar(u: PlayerCharacter): Unit = {
    if (Can_play && u.Can_play) {
      val atk: Int = u.attacking()
      evading(atk)
    }
    else {
      impossibleToFight(u)
    }
  }

  /** makes the evasion of the player.
   *
   * This function might be invoked when the battle starts.
   *
   * @param u The attacking Unit (wildUnit).
   */
  private def evading_to(u: Units): Unit = {
    if (Can_play && !u.dead()) {
      val atk: Int = u.attacking()
      evading(atk)
    }
    else {
      impossibleToFight(u)
    }
  }

  /** Starts the evasion of the player.
   *
   * This function might be invoked when the battle starts.
   *
   * @param u The attacking Chicken.
   */
  def evading_to_Chicken(u: Chicken): Unit = {
    evading_to(u)
  }

  /** Starts the evasion of the player.
   *
   * This function might be invoked when the battle starts.
   *
   * @param u The attacking RoboBall.
   */
  def evading_to_RoboBall(u: RoboBall): Unit = {
    evading_to(u)
  }

  /** Starts the evasion of the player.
   *
   * This function might be invoked when the battle starts.
   *
   * @param u The attacking Seagull.
   */
  def evading_to_Seagull(u: Seagull): Unit = {
    evading_to(u)
  }

}
