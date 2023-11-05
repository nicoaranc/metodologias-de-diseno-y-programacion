package cl.uchile.dcc.citric
package exceptions

/** When a Unit can't attack to other Unit */
class CannotAttack(details: String) extends Exception(s"It´s impossible to attack -- $details")

