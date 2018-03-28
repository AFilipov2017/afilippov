package ru.job4j.bank;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 25.03.18
 */
public class Account {
    private double value;
    private String requisites;

    public Account(String requisites, double value) {
        this.requisites = requisites;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }
}
