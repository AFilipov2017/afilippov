package ru.job4j.calculator;



/**
 * @author afilippov
 * @version 1
 * @since 09.11.2017
 */



public class Calculator {
    /**
     * add, subtraction, multiplication, division.
     * @param first, second.
     */
    private double result;
    private double res1;
    private double res2;
    private double res3;

    public void add(double first, double second) {
        this.result = first + second;
    }

    public double getResult() {
        return this.result;
    }

   public void subtract(double first, double second) {
        this.res1 = first - second;
    }

    public double getRes1() {
        return this.res1;
    }

    public void div(double first, double second) {
        this.res2 = first - second;
    }

    public double getRes2() {
        return this.res2;
    }

    public void multiple(double first, double second) {
        this.res3 = first - second;
    }

    public double getRes3() {
        return this.res3;
    }
}