package cl.uchile.dcc.citric
package model.abstractclasses

import model.traits.{Observer, Subject}

/** Represents an Abstract Observable Subject.
 *
 * Each Subject is an observable that can add Observers
 * to notify every update, also this functionalities
 * are implemented in the abstract class
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

abstract class AbstractSubject[T] extends Subject[T]{

  /** the List where observers observes the Subject */
  var observers: List[Observer[T]] = List.empty

  /** adds an observer to the Subject's observers List.
   *
   * This function might be invoked when the game starts.
   *
   * @param observer The observer to add.
   * */
  def addObserver(observer: Observer[T]): Unit = {
    observers = observer :: observers
  }

  /** notifies every observer in the Subject's observers List.
   *
   * This function might be invoked when a player reach the 6th Norma.
   *
   * @param value The event to notify.
   * */
  def notifyObservers(value: T): Unit = {
    for (observer <- observers) {
      observer.update(this, value)
    }
  }

}
