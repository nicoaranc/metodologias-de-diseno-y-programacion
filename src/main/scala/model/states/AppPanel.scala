package cl.uchile.dcc.citric
package model.states

import model.abstractclasses.AbstractState

class AppPanel extends AbstractState{

  override def doEffect(): Unit = {
    if (context.onAEncounterPanel()){
      context.setState(new DecFightWU())
    }
    else{
      /** apply the panel effect*/
      context.setPlayer()
      context.setState(new PlayerTurn())
    }
  }

}
