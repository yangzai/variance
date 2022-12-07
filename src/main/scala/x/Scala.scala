package x

import cats.*
import cats.arrow.*
import cats.implicits.*


@main def main =
  //immutable list is covariant
  val dogs: List[Dog] = List(Dog("alice"), Dog("bob"))
  val animals: List[Animal] = dogs
  val _animals: List[Animal] = dogs.widen
  val __animals: List[Animal] = dogs.map(identity) //widen === fmap toInterface
//  val _dogs: List[Dog] = animals

  //mutable array is invariant
  val mutDogs: Array[Dog] = dogs.toArray
  val mutAnimals: Array[Animal] = animals.toArray
//  val _mutAnimals: Array[Animal] = mutDogs
//  val _mutDogs: Array[Dog] = mutAnimals

  //invariant list (has a covariant functor instance)
  val idogs: IList[Dog] = dogs.toIList
//  val __ianimals: IList[Animal] = idogs
  val ianimals: IList[Animal] = idogs.widen
  val _ianimals: IList[Animal] = idogs.map(identity)

  //contravariant
  val animalEncoder: Encoder[Animal] = Encoder { a =>
    s"""{
       |  "type": ${a.typ}
       |  "owner": ${a.owner}
       |}""".stripMargin
  }
  val dogEncoder: Encoder[Dog] = animalEncoder
  val _dogEncoder: Encoder[Dog] = animalEncoder.narrow
  val __dogEncoder: Encoder[Dog] = animalEncoder.contramap(identity) //narrow === contramap toInterface
  println(dogEncoder.encode(dogs.head))
  println(_dogEncoder.encode(dogs.head))
  println(__dogEncoder.encode(dogs.head))

  //profunctor evidence
  Profunctor[Function1]
  Profunctor[-_ => +_]
  Profunctor[_ => _]
//  Profunctor[Either]

  val animalsToFruits: Animal => Fruit =
    case Cat(_) => Apple
    case Dog(_) => Orange
    case Pigeon(_) => Apple

  val mammalsToFood: Mammal => Food = animalsToFruits
  val _mammalsToFood: Mammal => Food = animalsToFruits.leftNarrow.rightWiden
  val __mammalsToFood: Mammal => Food = animalsToFruits.dimap(identity[Animal])(identity) //dimap toInterface toInterface
  println(mammalsToFood(dogs.head))
  println(_mammalsToFood(dogs.head))
  println(__mammalsToFood(dogs.head))
