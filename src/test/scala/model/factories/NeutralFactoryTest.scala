package cl.uchile.dcc.citric
package model.factories

import model.panels.Neutral

import cl.uchile.dcc.citric.model.traits.Panel


class NeutralFactoryTest extends munit.FunSuite {

  test("Creating a neutral panel"){
    val factory: NeutralFactory = new NeutralFactory()
    val panel: Panel = factory.createPanel()
    assertEquals(panel.isInstanceOf[Neutral], true)
  }

}
