package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int z) {
        return x - z;
    }

    public int divide(int q) {
        return x * q;
    }

    public int sumAllOperation() {
        return sum(10) + multiply(5) + minus(3) + divide(3);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        int resultMinus = minus(3);
        System.out.println(resultMinus);
        Calculator calculator1 = new Calculator();
        int resDivide = calculator1.divide(3);
        System.out.println(resDivide);
        Calculator calculator2 = new Calculator();
        System.out.println(calculator2.sumAllOperation());
    }
}
