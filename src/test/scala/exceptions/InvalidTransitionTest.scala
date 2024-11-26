package cl.uchile.dcc.citric
package exceptions

import model.traits.GameState

import cl.uchile.dcc.citric.model.controller.GameController
import cl.uchile.dcc.citric.model.states.{EndGame, PreGame}

class InvalidTransitionTest extends munit.FunSuite {

  test("Invalid transitions"){
    /** For example from PreGame and EndGame states */
    val state: GameState = new PreGame(new GameController())
    val state2: GameState = new EndGame(new GameController())
    intercept[InvalidTransition]{
      state.normaSixReached()
    }
    intercept[InvalidTransition] {
      state.starsForPlayer()
    }
    intercept[InvalidTransition] {
      state.fight_decision()
    }
    intercept[InvalidTransition] {
      state.checkPanel()
    }
    intercept[InvalidTransition] {
      state2.rollsDice()
    }
    intercept[InvalidTransition] {
      state2.checkHp()
    }
    intercept[InvalidTransition] {
      state2.doEffect()
    }
    intercept[InvalidTransition] {
      state2.playTurn()
    }
    intercept[InvalidTransition] {
      state2.startGame()
    }


  }

}
