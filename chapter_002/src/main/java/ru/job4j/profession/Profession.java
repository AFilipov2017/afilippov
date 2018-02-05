package ru.job4j.profession;

public class Profession {
   String name;
   String tools;

   public Profession() {

   }

   public Profession(String name, String tools) {
       this.name = name;
       this.tools = tools;
    }

    public Profession(String name) {

       this.name = name;
    }

    public String getName() {

       return name;
    }

    public String getTools() {

       return tools;
    }
}
