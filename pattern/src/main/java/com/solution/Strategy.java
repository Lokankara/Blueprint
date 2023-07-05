package com.solution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Strategy {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Betty", 15));
        animals.add(new Cat("Smokey", 5));
        animals.add(new Dog("Buddy", 20));
        animals.add(new Cat("Whisky", 8));

        AnimalSort<Animal> collection = new AnimalSort<>(animals, new AnimalWeightStrategy());
        collection.sort();
        System.out.println(collection.getAnimals());
        collection.setSortStrategy(new AnimalNameStrategy());
        collection.sort();
        System.out.println(collection.getAnimals());
    }
}

interface AnimalStrategy<T extends Animal> {
    void sort(List<T> animals);
}

class AnimalWeightStrategy implements AnimalStrategy<Animal> {
    public void sort(List<Animal> animals) {
        animals.sort(Comparator.comparingInt(Animal::getWeight));
    }
}

class AnimalNameStrategy implements AnimalStrategy<Animal> {
    public void sort(List<Animal> animals) {
        animals.sort(Comparator.comparing(Animal::getName));
    }
}

@Setter
@Getter
@ToString
@AllArgsConstructor
class AnimalSort<T extends Animal> {
    private final List<T> animals;
    private AnimalStrategy<T> sortStrategy;

    public void sort() {
        sortStrategy.sort(animals);
    }
}

class Cat extends Felidae {
    protected Cat(String name, int weight) {
        super(name, weight);
    }
}

class Dog extends Canidae {
    public Dog(String name, int weight) {
        super(name, weight);
    }
}

abstract class Felidae extends Animal {
    protected Felidae(String name, int weight) {
        super(name, weight);
    }
}

abstract class Canidae extends Animal {
    protected Canidae(String name, int weight) {
        super(name, weight);
    }
}

@Getter
@ToString
@AllArgsConstructor
abstract class Animal {
    private final String name;
    private final int weight;
}
