package cl.uchile.dcc.citric
package model.traits

trait Observer[T] {

  def update(observable: Subject[T], value: T): Unit

}
