package cl.uchile.dcc.citric
package exceptions
import model.panels.home
import model.player.PlayerCharacter
import model.abstractclasses.WildUnit
import model.wild.Chicken
import scala.util.Random

class CannotAttackTest extends munit.FunSuite {
  test("Attack isn't possible in many ways") {
    val panel: home = new home()
    val player = new PlayerCharacter("Pedro", 5, 1, 1, -1, new Random(11), panel)

    val panel2: home = new home()
    val player2 = new PlayerCharacter("Diego", 5, 1, 1, -1, new Random(11), panel2)

    val npc: WildUnit = new Chicken()

    /** player is in Recovery phase */
    player.Hp_=(0)
    player.defeated()

    intercept[CannotAttack] {
      player.can_attack(player2)
    }

    /** the playerCharacter rival is in Recovery phase */
    intercept[CannotAttack] {
      player2.can_attack(player)
    }

    /** the wild unit can't attack a PlayerCharacter in RecoveryPhase */
    intercept[CannotAttack] {
      npc.can_attack(player)
    }

    /** the player character can't attack to a dead wild unit */
    npc.Hp_=(0)
    intercept[CannotAttack] {
      player2.can_attack(npc)
    }

  }
}
