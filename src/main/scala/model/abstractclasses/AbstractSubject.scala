package cl.uchile.dcc.citric
package model.abstractclasses

import model.traits.{Observer, Subject}

abstract class AbstractSubject[T] extends Subject[T]{

  private var observers: List[Observer[T]] = List.empty


  def addObserver(observer: Observer[T]): Unit = {
    observers = observer :: observers
  }

  def notifyObservers(value: T): Unit = {
    for (observer <- observers) {
      observer.update(this, value)
    }
  }

}
