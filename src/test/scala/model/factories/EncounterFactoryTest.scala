package cl.uchile.dcc.citric
package model.factories

import model.traits.Panel

import cl.uchile.dcc.citric.model.panels.Encounter

class EncounterFactoryTest extends munit.FunSuite {

  test("Creating a encounter panel"){
    val factory: EncounterFactory = new EncounterFactory()
    val panel: Panel = factory.createPanel()
    assertEquals(panel.isInstanceOf[Encounter], true)
  }

}
