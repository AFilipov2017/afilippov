package ru.job4j.map;

import java.util.Calendar;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 11.06.2018
 */
public class User {
    String name;
    int children;
    Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public int getHash() {
        return hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + getName().hashCode();
        hash = 31 * hash + getChildren();
        hash = 31 * hash + getBirthday().hashCode();
        return hash;
    }
}
