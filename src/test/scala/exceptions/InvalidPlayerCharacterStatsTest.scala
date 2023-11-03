package cl.uchile.dcc.citric
package exceptions
import model.player.PlayerCharacter
import model.panels.home
import scala.util.Random


class InvalidPlayerCharacterStatsTest extends munit.FunSuite {
  val panel1: home = new home()
  val player1 = new PlayerCharacter("npc", 5, 1, 1, -1, new Random(11), panel1)

  test("Invalid Hit Points stat"){
    intercept[InvalidPlayerCharacterStats]{
      player1.Hp_=(7)
    }
  }

}
