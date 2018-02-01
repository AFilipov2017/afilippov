package ru.job4j.profession;

public class Teacher extends Profession {
    private String name = "Buck";
    private String tools = "computer";

    public Teacher() {

    }

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(String name, String tools) {
        this.name = name;
        this.tools = tools;
    }


    public  Knoledge teach(Student student) {
Knoledge knoledge = new Knoledge("");
return knoledge;
    }
}


