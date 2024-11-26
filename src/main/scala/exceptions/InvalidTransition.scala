package cl.uchile.dcc.citric
package exceptions

/** When the controller tries to make an invalid transition between states*/

class InvalidTransition(details: String) extends Exception(details){

}
