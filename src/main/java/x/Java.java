package x;

public class Java {
    static abstract class Animal {
        private String owner;
        Animal(String o) { owner = o; }
    }
    static final class Dog extends Animal { Dog(String o) { super(o); } }
    static final class Cat extends Animal { Cat(String o) { super(o); } }
    public static Dog dog(String o) { return (new Dog(o)); }
    public static Cat cat(String o) { return (new Cat(o)); }

    public static void main (String[] args) {
        System.out.println("start");
        Dog[] dogs = { dog("alice"), dog("bob") };
        Cat cat = cat("alice");
//        dogs[0] = cat;
        Animal[] animals = dogs;
        // this will compile but fail at runtime
//        animals[0] = cat;
        System.out.println("end");
    }
}
