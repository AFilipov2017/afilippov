package ru.job4j.bank;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 25.03.18
 */
public class User implements Comparable<User> {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(User o) {
        int result = this.name.compareTo(o.name);
        return result != 0 ? result : this.getPassport().compareTo(o.getPassport());
    }
}
