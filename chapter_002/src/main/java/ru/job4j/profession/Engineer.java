package ru.job4j.profession;

public class Engineer extends Profession {
    private String name;

    public Engineer() {
    }
    public Engineer(String name) {
        super(name);
    }

    public Create devices(Tools tools) {
        Create create = new Create("create");
        return create;
    }
}
