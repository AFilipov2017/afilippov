package ru.job4j.profession;



public class Doctor extends Profession {

    public Doctor() {
    }

    public Doctor(String name, String tools) {
        this.name = name;
        this.tools = tools;
    }

    public Doctor(String aName) {
        this.name = aName;
    }


    public Diagnose heal(Pacient pacient) {

        Diagnose diagnose = new Diagnose("not sick");
        return diagnose;
    }
}


