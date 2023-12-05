package cl.uchile.dcc.citric
package model.traits

import model.player.PlayerCharacter

/** Represents a general Unit.
 *
 * Each Unit have different stats for maxHp, evasion, defense, attack.
 * Also every Unit can get involved in a battle, with the possibilities to attack, defend and evade. And a battle
 * ends, each Unit can get some stars to save
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

trait Units {

  /** current Hit Points of the Unit */
  var Hp: Int

  /** Unit's maximum Hit Points */
  val maxHp: Int

  /** Unit's attack stat */
  val attack: Int

  /** Unit's attack stat */
  val defense: Int

  /** Unit's attack stat */
  val evasion: Int

  /** current stars of the Unit */
  var stars: Int

  def dead(): Boolean
  /** give stars to the Unit.
   *
   * This function might be invoked when the Unit wins
   * a battle against a player.
   *
   * @param p The player defeated.
   */
  def winStars(p: PlayerCharacter): Unit

  /** gives stars to the Unit when defeats a player.
   *
   * This function might be invoked when the battle ends.
   *
   * @param u The defeated player.
   */
  def win_against_PlayChar(u: PlayerCharacter): Unit

  /** Makes the attack, return the attack points.
   *
   * This function might be invoked when the battle starts.
   *
   */
  def attacking(): Int

  /** Makes the defense of the Unit.
   *
   * This function might be invoked during the battle.
   *
   * @param a The attack points to defend.
   */
  def defending(a: Int) : Unit

  /** Makes the evasion of the Unit.
   *
   * This function might be invoked during the battle.
   *
   * @param a The attack points to evade.
   */
  def evading(a: Int) : Unit

  /** Starts the defense of the Unit.
   *
   * This function might be invoked when the battle starts.
   *
   * @param u The attacking player.
   */
  def defending_to_PlayChar(u: PlayerCharacter): Unit

  /** Starts the evasion of the Unit.
   *
   * This function might be invoked when the battle starts.
   *
   * @param u The attacking player.
   */
  def evading_to_PlayChar(u: PlayerCharacter): Unit


}
