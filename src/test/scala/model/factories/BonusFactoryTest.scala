package cl.uchile.dcc.citric
package model.factories

import model.traits.Panel

import cl.uchile.dcc.citric.model.panels.Bonus

class BonusFactoryTest extends munit.FunSuite {

  test("Creating a bonus panel"){
    val factory: BonusFactory = new BonusFactory()
    val panel: Panel = factory.createPanel()
    assertEquals(panel.isInstanceOf[Bonus], true)
  }

}
