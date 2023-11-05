package cl.uchile.dcc.citric
package exceptions

/** The Hit Points of the player can't surpass the maxHp stat */
class InvalidPlayerCharacterStats (details: String) extends Exception(s"The new stat is invalid -- $details")
