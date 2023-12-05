package cl.uchile.dcc.citric
package model.wild

import cl.uchile.dcc.citric.model.abstractclasses.WildUnit
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.util.Random

/** Represents a single RoboBall.
 *
 * Each RoboBall have the same stats, and the same behaviour.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class RoboBall extends WildUnit {

  /** RoboBall's maximum Hit Points */
  val maxHp: Int = 3

  /** Current Hit points of the RoboBall */
  private var _Hp: Int = maxHp

  /** getter of the RoboBall's Hit points */
  def Hp: Int = _Hp

  /** Setter of the Hp of the RoboBall.
   *
   * This function might be invoked in a battle.
   *
   * @param NewHp The new Hit Points of the RoboBall.
   */
  def Hp_=(NewHp: Int): Unit = {
    if (NewHp <= maxHp && NewHp >= 0) {
      _Hp = NewHp
    }
  }

  /** RoboBall's attack stat */
  val attack: Int = -1

  /** RoboBall's defense stat */
  val defense: Int = 1

  /** RoboBall's evasion stat */
  val evasion: Int = -1

  /** current RoboBall's stars */
  private var _stars: Int = 0

  /** getter of the stars of the RoboBall */
  def stars: Int = _stars

  /** Setter of the stars of the RoboBall.
   *
   * This function might be invoked when a battle ends.
   *
   * @param NewStars The new stars of the RoboBall.
   */
  def stars_=(NewStars: Int): Unit = {
    if (NewStars >= 0) {
      _stars = NewStars
    }
  }

  /** give stars to the RoboBall.
   *
   * This function might be invoked when the RoboBall wins
   * a battle against a player.
   *
   * @param p The player defeated.
   */
  def winStars(p: PlayerCharacter): Unit = {
    val a: Int = p.stars / 2
    val b: Int = stars + a
    stars_=(b)
  }

  /** makes the exchange of stars of the RoboBall when is defeated.
   *
   * This function might be invoked when the battle ends.
   *
   * @param u The winner player.
   */
  def defeated(u: PlayerCharacter): Unit = {
    u.win_against_RoboBall(this)
    stars_=(0)
  }

  /** gives stars to the RoboBall when defeats a player.
   *
   * This function might be invoked when the battle ends.
   *
   * @param u The defeated player.
   */
  def win_against_PlayChar(u: PlayerCharacter): Unit = {
    winStars(u)
  }

  /** delegates the defense/evasion from the playerCharacter to the RoboBall's attack.
   *
   * This function might be invoked during a fight.
   *
   * @param u The player to attack.
   * */

   def attacking_to_PlayChar(u: PlayerCharacter): Unit = {
     val roll: Int = new Random().nextInt(2) + 1
     if (roll == 1){
       u.defending_to_RoboBall(this)
     }
     else{
       u.evading_to_RoboBall(this)
     }
   }


}
