package cl.uchile.dcc.citric
package model.traits

trait Subject [T] {

  def addObserver(observer: Observer[T]): Unit
  def notifyObservers(value: T): Unit

}
