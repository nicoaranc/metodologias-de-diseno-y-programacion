package cl.uchile.dcc.citric
package model.paneles

import model.traits.Panel

import scala.collection.mutable.ArrayBuffer

class neutral extends panel{

  val characters: ArrayBuffer[PlayerCharacter]

  var nextPanels
}
