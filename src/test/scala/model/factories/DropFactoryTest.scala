package cl.uchile.dcc.citric
package model.factories

import model.traits.Panel

import cl.uchile.dcc.citric.model.panels.Drop

class DropFactoryTest extends munit.FunSuite {

  test("Creating a drop panel"){
    val factory: DropFactory = new DropFactory()
    val panel: Panel = factory.createPanel()
    assertEquals(panel.isInstanceOf[Drop], true)
  }

}