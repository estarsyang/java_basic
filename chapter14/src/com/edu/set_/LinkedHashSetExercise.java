package com.edu.set_;

import java.util.LinkedHashSet;
import java.util.Objects;

/**
 *    1. a `Car` class, it have `name`, `price` properties.
 *    2. Create three cars, store in LinkedHashSet.
 *    3. When `name` and `price` are equal to exist data,
 *    it's the same employee. Can't be inserted into LinkedHashSet.
 */

public class LinkedHashSetExercise {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("auto",1000));
        linkedHashSet.add(new Car("bmw",1200));
        linkedHashSet.add(new Car("auto",1000));
        System.out.println(linkedHashSet);
    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
