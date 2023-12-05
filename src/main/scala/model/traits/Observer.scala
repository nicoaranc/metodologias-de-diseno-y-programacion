package cl.uchile.dcc.citric
package model.traits

/** Represents a general Observer.
 *
 * Each Observer can observe a Subject and being
 * notified when the Subject change his state.
 *
 * @author [[https://github.com/nicoaranc Nicolás Arancibia A.]]
 */

trait Observer[T] {

  /** The observer is notified by a Subject.
   *
   * This function might be invoked when a
   * player reach the 6th Norma.
   *
   * @param observable The observable Subject
   * @param value The notified event
   * */
  def update(observable: Subject[T], value: T): Unit

}
