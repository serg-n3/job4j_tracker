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
        return z - x;
    }

    public double divide(double q) {
        return q / x;
    }

    public double sumAllOperation(int p) {
        return sum(p) + multiply(p) + minus(p) + divide(p);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        int resultMinus = minus(3);
        System.out.println(resultMinus);
        double resDivide = calculator.divide(3);
        System.out.println(resDivide);
        System.out.println(calculator.sumAllOperation(7));
    }
}
