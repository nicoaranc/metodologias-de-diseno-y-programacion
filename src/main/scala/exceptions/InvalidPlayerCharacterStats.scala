package cl.uchile.dcc.citric
package exceptions

class InvalidPlayerCharacterStats (details: String) extends Exception(s"The new stat is invalid -- $details")
