package cl.uchile.dcc.citric
package model.wild

import cl.uchile.dcc.citric.model.abstractclasses.WildUnit
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.util.Random

/** Represents a single Seagull.
 *
 * Each Seagull have the same stats, and the same behaviour.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class Seagull extends WildUnit {

  /** Seagull's maximum Hit Points */
  val maxHp: Int = 3

  /** Current Hit points of the Seagull */
  private var _Hp: Int = maxHp

  /** getter of the Seagull's Hit points */
  def Hp: Int = _Hp

  /** Setter of the Hp of the seagull.
   *
   * This function might be invoked in a battle.
   *
   * @param NewHp The new Hit Points of the seagull.
   */
  def Hp_=(NewHp: Int): Unit = {
    if (NewHp <= maxHp && NewHp >= 0) {
      _Hp = NewHp
    }
  }

  /** Seagull's attack stat */
  val attack: Int = 1

  /** Seagull's defense stat */
  val defense: Int = -1

  /** Seagull's evasion stat */
  val evasion: Int = -1

  /** current Seagull's stars */
  private var _stars: Int = 0

  /** getter of the stars of the Seagull */
  def stars: Int = _stars

  /** Setter of the stars of the seagull.
   *
   * This function might be invoked when a battle ends.
   *
   * @param NewStars The new stars of the seagull.
   */
  def stars_=(NewStars: Int): Unit = {
    if (NewStars >= 0) {
      _stars = NewStars
    }
  }

  /** give stars to the seagull.
   *
   * This function might be invoked when the seagull wins
   * a battle against a player.
   *
   * @param p The player defeated.
   */
  def winStars(p: PlayerCharacter): Unit = {
    val a: Int = p.stars / 2
    val b: Int = stars + a
    stars_=(b)
  }

  /** makes the exchange of stars of the seagull when is defeated.
   *
   * This function might be invoked when the battle ends.
   *
   * @param u The winner player.
   */
  def defeated(u: PlayerCharacter): Unit = {
    u.win_against_Seagull(this)
    stars_=(0)
  }

  /** gives stars to the seagull when defeats a player.
   *
   * This function might be invoked when the battle ends.
   *
   * @param u The defeated player.
   */
  def win_against_PlayChar(u: PlayerCharacter): Unit = {
    winStars(u)
  }

  /** delegates the defense/evasion from the playerCharacter to the seagull's attack.
   *
   * This function might be invoked during a fight.
   *
   * @param u The player to attack.
   * */

  def attacking_to_PlayChar(u: PlayerCharacter): Unit = {
    val roll: Int = new Random().nextInt(2) + 1
    if (roll == 1){
      u.defending_to_Seagull(this)
    }
    else{
      u.evading_to_Seagull(this)
    }
   }


}
