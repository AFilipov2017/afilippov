package ru.job4j.profession;

public class Teacher extends Profession {
    public Teacher() {
    }
    public Teacher(String name, String tools) {
        super(name, tools);
    }

    public Teacher(String name) {
        super(name);
    }

    public  Knoledge teach(Student student) {
        Knoledge knoledge = new Knoledge("");
        return knoledge;
    }
}


