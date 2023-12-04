package cl.uchile.dcc.citric
package model.wild

import cl.uchile.dcc.citric.model.abstractclasses.WildUnit
import cl.uchile.dcc.citric.model.player.PlayerCharacter

import scala.util.Random

/** Represents a single Chicken.
 *
 * Each Chicken have the same stats, and the same behaviour.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

class Chicken extends WildUnit{

  /** Chicken's maximum Hit Points */
  val maxHp: Int = 3

  /** Current Hit points of the Chicken */
  private var _Hp: Int = maxHp

  /** getter of the Chicken's Hit points */
  def Hp: Int = _Hp

  /** Setter of the Hp of the Chicken.
   *
   * This function might be invoked in a battle.
   *
   * @param NewHp The new Hit Points of the Chicken.
   */
  def Hp_=(NewHp: Int): Unit = {
    _Hp = NewHp
  }

  /** Chicken's attack stat */
  val attack: Int = -1

  /** Chicken's defense stat */
  val defense: Int = -1

  /** Chicken's evasion stat */
  val evasion: Int = 1

  /** current Chicken's stars */
  private var _stars: Int = 0

  /** getter of the stars of the Chicken */
  def stars: Int = _stars

  /** Setter of the stars of the Chicken.
   *
   * This function might be invoked when a battle ends.
   *
   * @param NewStars The new stars of the Chicken.
   */
  def stars_=(NewStars: Int): Unit = {
    _stars = NewStars
  }

  /** give stars to the Chicken.
   *
   * This function might be invoked when the Chicken wins
   * a battle against a player.
   *
   * @param p The player defeated.
   */
  def winStars(p: PlayerCharacter): Unit = {
    val a: Int = p.stars / 2
    val b: Int = stars + a
    stars_=(b)
  }

  /** makes the exchange of stars of the Chicken when is defeated.
   *
   * This function might be invoked when the battle ends.
   *
   * @param u The winner player.
   */
  def defeated(u: PlayerCharacter): Unit = {
    u.win_against_Chicken(this)
    stars_=(0)
  }

  /** gives stars to the Chicken when defeats a player.
   *
   * This function might be invoked when the battle ends.
   *
   * @param u The defeated player.
   */
  def win_against_PlayChar(u: PlayerCharacter): Unit = {
    winStars(u)
  }


  /** method that stars an attack from the Chicken to a PlayerCharacter */
  def attacking_to_PlayChar(u: PlayerCharacter): Unit = {
    val roll: Int = new Random().nextInt(2) + 1
    if (roll == 1) {
      u.defending_to_Chicken(this)
    }
    else{
      u.evading_to_Chicken(this)
    }

  }

}
