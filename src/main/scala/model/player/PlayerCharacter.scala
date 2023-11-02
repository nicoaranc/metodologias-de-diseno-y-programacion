package cl.uchile.dcc.citric
package model.player
import model.wild.{Seagull,RoboBall,Chicken}
import model.norma.{Norma1,Norma2,Norma3,Norma4,Norma5,Norma6}
import model.traits.{Norma, Units, WildUnit, Panel}
import model.panels.home


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
  *
  * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/~Your github account~/ ~Your Name~]]
  */
class PlayerCharacter(val name: String,
              val maxHp: Int,
              val attack: Int,
              val defense: Int,
              val evasion: Int,
              val randomNumberGenerator: Random = new Random(),
              val panelOwned: home) extends Units{

  /** instances of each Norma */
  private val n1: Norma = new Norma1()
  private val n2: Norma = new Norma2()
  private val n3: Norma = new Norma3()
  private val n4: Norma = new Norma4()
  private val n5: Norma = new Norma5()
  private val n6: Norma = new Norma6()

  /** current Hp of the player, at the beginning of the game is the maxHp */
  private var _Hp: Int = maxHp
  def Hp: Int = _Hp
  def Hp_=(NewHp: Int): Unit = {
    _Hp = NewHp
  }
  /** current stars of the player, at the beginning of the game is 0 */
  private var _stars: Int = 0
  def stars: Int = _stars
  def stars_=(NewStars: Int): Unit = {
    _stars = NewStars
  }
  /** current Norma of the player, at the beginning of the game is 1 */
  private var _norma: Norma = n1
  def norma: Norma = _norma
  def norma_=(NewNorma: Norma): Unit = {
    _norma = NewNorma
  }
  private var _norma_id: Int = 1
  def norma_id: Int = _norma_id
  def norma_id_=(NewNormaId: Int): Unit = {
    _norma_id = NewNormaId
  }
  /** current victories of the player, at the beginning of the game is 0 */
  private var _victories: Int = 0
  def victories: Int = _victories
  def victories_=(NewVictories: Int): Unit = {
    _victories = NewVictories
  }
  /** current Recovery status */
  private var _Recovery: Boolean = false
  def Recovery: Boolean = _Recovery
  def Recovery_=(NewRecovery: Boolean): Unit = {
    _Recovery = NewRecovery
  }
  /** current state of playing */
  private var _Can_play: Boolean = true
  def Can_play: Boolean = _Can_play
  def Can_play_=(NewCanPlay: Boolean): Unit = {
    _Can_play = NewCanPlay
  }
  /** Array that contains all the instances of each Norma */
  val NormaArray: ArrayBuffer[Norma] = new ArrayBuffer[Norma]()
  NormaArray.addOne(n1)
  NormaArray.addOne(n2)
  NormaArray.addOne(n3)
  NormaArray.addOne(n4)
  NormaArray.addOne(n5)
  NormaArray.addOne(n6)

  /** the goal to reach the next level of Norma and the kind of the goal */
  private var _goal: Int = 0
  def goal: Int = _goal
  def goal_=(NewGoal: Int): Unit = {
    _goal = NewGoal
  }
  private var _kind_goal: String = ""
  def kind_goal: String = _kind_goal
  def kind_goal_=(NewKindGoal: String): Unit = {
    _kind_goal = NewKindGoal
  }


  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }


  /** when the player defeats a Wild Unit wins one victory to the count */
  def victories_perBattle(u: WildUnit): Unit = {
    val a: Int = victories + 1
    victories_=(a)
  }

  /** when the player defeats another Player wins two victories to the count */
  def victories_perBattle(u: PlayerCharacter): Unit = {
    val a: Int = victories + 2
    victories_=(a)
  }

  /** when the player is defeated by a Wild Unit, drops the half of the stars and gives it to the Wild Unit */
  def dropStars_battle(u: WildUnit): Unit = {
    val a: Int = stars/2
    stars_=(a)
  }

  def winStars_battle(u: Chicken): Unit = {
    val a: Int = stars + u.stars + 3
    stars_=(a)
  }

  def winStars_battle(u: RoboBall): Unit = {
    val a: Int = stars + u.stars + 2
    stars_=(a)
  }

  def winStars_battle(u: Seagull): Unit = {
    val a: Int = stars + u.stars + 2
    stars_=(a)
  }

  /** when the player is defeated, teh player enters to the Recovery phase */
  def defeated(): Unit = {
    if (Hp == 0){
      Recovery_= (true)
      Can_play_= (false)
    }
  }
  


  def attacking(u: PlayerCharacter): Int = {
    if (Can_play && u.Can_play){
        val rollATK = rollDice()
        return rollATK + attack
      }
    else{
      return 0
    }
  }

  def attacking(u: WildUnit): Int = {
    if (Can_play && !u.dead()) {
        val rollATK = rollDice()
        val aux = rollATK + attack
        if (aux >= 0) {
          return aux
        }
        else{
          return 0;
        }

    }
    else{
      return 0
    }
  }

  override def defending(a: Int): Unit = {
    val rollDEF = rollDice()
    val receive = a - (rollDEF + defense)
    if (a == 0){
      return
    }
    if (receive < 1){
      val b = Hp - 1
      Hp_=(b)
    }
    else{
      if (receive >= Hp){
        Hp_= (0)
      }
      else{
        val b = Hp - receive
        Hp_= (b)
      }
    }
  }

  override def evading(a: Int): Unit = {
    val rollEVA = rollDice()
    val aux = rollEVA + evasion
    if (a == 0){
      return
    }
    if (aux > a){
      return
    }
    else{
      if (a > Hp){
        Hp_= (0)
      }
      else{
        val b = Hp - a
        Hp_= (b)
      }
    }
  }

  /** norma_Clear checks if the player already done the norma_check
   * with positive results, increases his norma level */
  def norma_Clear(panel: home): Unit = {
    if (panel.norma_check(this)){
      val a: Int = norma_id
      norma_= (NormaArray(a))
      norma_id_= (a + 1)
    }

  }

}
