package ru.job4j.tracker.models;
/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since 06.02.2018
 */
public class Item {
    private String id;
    public String name;
    public String description;
    public long created;
    public String[] comments;

    public Item() {

    }

    public Item(String name, String description, long created, String[] comments) {
        this.name = name;
        this.description = description;
        this.created = created;
        this.comments = comments;
    }

    public String getId() {
        return this.id;
    }

    public String setId(String id) {
        this.id = id;
		return id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }
}