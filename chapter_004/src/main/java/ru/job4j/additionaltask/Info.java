package ru.job4j.additionaltask;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 03.10.2018
 */
public class Info {
    private int add;
    private int delete;
    private int edit;

    public Info(int add, int delete, int edit) {
        this.add = add;
        this.delete = delete;
        this.edit = edit;
    }

    public int getAdd() {
        return add;
    }

    public void setAdd(int add) {
        this.add = add;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public int getEdit() {
        return edit;
    }

    public void setEdit(int edit) {
        this.edit = edit;
    }
}
