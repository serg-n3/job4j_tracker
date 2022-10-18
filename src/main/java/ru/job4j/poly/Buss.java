package ru.job4j.poly;

public class Buss implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " автобус двигается по скоростным трассам");

    }
}
