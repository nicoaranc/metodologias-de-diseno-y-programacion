package cl.uchile.dcc.citric
package model.board

class BoardTest extends munit.FunSuite {

  test("Adding a neutral panel"){
    val board: Board = new Board()
    board.addNeutral()
    assertEquals(board.PanelsArray.isEmpty, false)
  }

  test("Adding a home panel") {
    val board: Board = new Board()
    board.addHome()
    assertEquals(board.PanelsArray.isEmpty, false)
  }

  test("Adding a drop panel") {
    val board: Board = new Board()
    board.addDrop()
    assertEquals(board.PanelsArray.isEmpty, false)
  }

  test("Adding a encounter panel") {
    val board: Board = new Board()
    board.addEncounter()
    assertEquals(board.PanelsArray.isEmpty, false)
  }

  test("Adding a bonus panel") {
    val board: Board = new Board()
    board.addBonus()
    assertEquals(board.PanelsArray.isEmpty, false)
  }

}
