package x

import cats.*
import cats.derived.*

//    Animal
//   /      \
// Bird    Mammal
//  |      /    \
// Pigeon Cat   Dog
sealed trait Animal(t: String, o: String) { val typ: String = t; val owner: String = o }
sealed abstract class Mammal(t: String, o: String) extends Animal(t, o)
sealed abstract class Bird(t: String, o: String) extends Animal(t, o)
case class Dog(o: String) extends Mammal("Dog", o)
case class Cat(o: String) extends Mammal("Cat", o)
case class Pigeon(o: String) extends Bird("Pigeon", o)

//    Food
//      |
//    Fruit
//   /     \
// Apple Orange
trait Food
abstract class Fruit extends Food
case object Apple extends Fruit
case object Orange extends Fruit

case class Encoder[-A](encode: A => String) derives Contravariant

object IList: //subtype invariant but functorially covariant
  opaque type IList[A] = List[A]
  extension [A](l: List[A]) def toIList: IList[A] = l
  given Functor[IList] = semiauto.functor

export IList.IList
export IList.toIList
