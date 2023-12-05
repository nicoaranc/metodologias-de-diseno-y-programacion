package cl.uchile.dcc.citric
package model.factories

import model.traits.Panel

import cl.uchile.dcc.citric.model.panels.Home

class HomeFactoryTest extends munit.FunSuite {

  test("Creating a home panel"){
    val factory: HomeFactory = new HomeFactory()
    val panel: Panel = factory.createPanel()
    assertEquals(panel.isInstanceOf[Home], true)
  }

}
