package ru.job4j.profession;



public class Doctor extends Profession {

    public Doctor(String name, String tools) {

        super(name, tools);
    }

    public Doctor(String name) {

        super(name);
    }

    public Diagnose heal(Pacient pacient) {

        Diagnose diagnose = new Diagnose("not sick");
        return diagnose;
    }
}


