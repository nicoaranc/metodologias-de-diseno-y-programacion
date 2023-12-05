package cl.uchile.dcc.citric
package exceptions
import model.panels.Home
import model.player.PlayerCharacter
import model.abstractclasses.WildUnit
import model.wild.{Chicken,RoboBall,Seagull}
import scala.util.Random

class CannotAttackTest extends munit.FunSuite {
  test("Attack isn't possible in many ways") {
    val panel: Home = new Home()
    val player = new PlayerCharacter("Pedro", 5, 1, 1, -1, new Random(11), panel)

    val panel2: Home = new Home()
    val player2 = new PlayerCharacter("Diego", 5, 1, 1, -1, new Random(11), panel2)

    val npc: Chicken = new Chicken()
    val npc2: RoboBall = new RoboBall()
    val npc3: Seagull = new Seagull()

    /** player is in Recovery phase */
    player.Hp_=(0)
    player.defeated(npc)

    intercept[CannotAttack] {
      player2.defending_to_PlayChar(player)
    }

    /** the playerCharacter rival is in Recovery phase */
    player.Hp_= (1)
    player.Can_play_= (true)
    player.Recovery_= (false)
    player2.Hp_= (0)
    player2.defeated(npc)
    intercept[CannotAttack] {
      player2.defending_to_PlayChar(player)
    }
    intercept[CannotAttack] {
      player2.evading_to_PlayChar(player)
    }

    /** the wild unit can't attack a PlayerCharacter in RecoveryPhase */
    intercept[CannotAttack] {
      player2.defending_to_Chicken(npc)
    }
    intercept[CannotAttack] {
      player2.evading_to_Chicken(npc)
    }
    intercept[CannotAttack] {
      player2.defending_to_RoboBall(npc2)
    }
    intercept[CannotAttack] {
      player2.evading_to_RoboBall(npc2)
    }
    intercept[CannotAttack] {
      player2.defending_to_Seagull(npc3)
    }
    intercept[CannotAttack] {
      player2.evading_to_Seagull(npc3)
    }
    intercept[CannotAttack] {
      npc3.defending_to_PlayChar(player2)
    }
    intercept[CannotAttack] {
      npc3.evading_to_PlayChar(player2)
    }

    /** the player character can't attack to a dead wild unit */
    npc.Hp_=(0)
    println(npc.Hp)
    npc2.Hp_= (0)
    println(npc2.Hp)
    npc3.Hp_=(0)
    println(npc3.Hp)
    intercept[CannotAttack] {
      npc.defending_to_PlayChar(player)
    }
    intercept[CannotAttack] {
      npc.evading_to_PlayChar(player)
    }
    intercept[CannotAttack] {
      npc2.defending_to_PlayChar(player)
    }
    intercept[CannotAttack] {
      npc2.evading_to_PlayChar(player)
    }
    intercept[CannotAttack] {
      npc3.defending_to_PlayChar(player)
    }
    intercept[CannotAttack] {
      npc3.evading_to_PlayChar(player)
    }
    intercept[CannotAttack]{
      player.defending_to_Chicken(npc)
    }
    intercept[CannotAttack] {
      player.defending_to_RoboBall(npc2)
    }
    intercept[CannotAttack] {
      player.defending_to_Seagull(npc3)
    }
  }
}
