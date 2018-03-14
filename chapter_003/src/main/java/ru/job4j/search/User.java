package ru.job4j.search;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 14.03.2018
 */
public class User {
    private Integer id;
    private String name;
    private String city;

    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
