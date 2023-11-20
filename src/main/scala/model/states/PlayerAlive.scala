package cl.uchile.dcc.citric
package model.states

import model.controller.Gamecontroller

class PlayerAlive(context: Gamecontroller) extends GameState(context){

  context.state = this

}
