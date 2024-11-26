package cl.uchile.dcc.citric
package model.norma

class NormaSixTest extends munit.FunSuite {

  val norma1: Norma1 = new Norma1()
  val norma2: Norma2 = new Norma2()
  val norma3: Norma3 = new Norma3()
  val norma4: Norma4 = new Norma4()
  val norma5: Norma5 = new Norma5()
  val norma6: Norma6 = new Norma6()

  test("Norma6?"){
    assertEquals(norma1.normaSix(),false)
    assertEquals(norma2.normaSix(),false)
    assertEquals(norma3.normaSix(),false)
    assertEquals(norma4.normaSix(),false)
    assertEquals(norma5.normaSix(),false)
    assertEquals(norma6.normaSix(),true)
  }
}
