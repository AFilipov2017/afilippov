package ru.job4j.pseudo;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 15.02.2018
 */
public class Triangle implements Shape {
    public String draw() {
        String separator = System.getProperty("line.separator");
        StringBuilder pic = new StringBuilder();
        pic.append("   +");
        pic.append(separator);
        pic.append("  + +");
        pic.append(separator);
        pic.append(" +   +");
        pic.append(separator);
        pic.append("+++++++");
        return pic.toString();
    }
}