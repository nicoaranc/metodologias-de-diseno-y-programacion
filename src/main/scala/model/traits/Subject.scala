package cl.uchile.dcc.citric
package model.traits

/** Represents a general Observable Subject.
 *
 * Each Subject is an observable that can add Observers
 * to notify every update
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

trait Subject [T] {

  /** the List where observers observes the Subject */
  var observers: List[Observer[T]]

  /** adds an observer to the Subject's observers List.
   *
   *  This function might be invoked when the game starts.
   *
   *  @param observer The observer to add.
   *  */
  def addObserver(observer: Observer[T]): Unit


  /** notifies every observer in the Subject's observers List.
   *
   * This function might be invoked when a player reach the 6th Norma.
   *
   * @param value The event to notify.
   * */
  def notifyObservers(value: T): Unit

}
