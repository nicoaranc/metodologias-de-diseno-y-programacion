package cl.uchile.dcc.citric
package exceptions

class CannotAttack(details: String) extends Exception(s"It´s impossible to attack -- $details")

