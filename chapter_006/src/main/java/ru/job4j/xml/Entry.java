package ru.job4j.xml;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 04.03.2019
 */
@XmlRootElement
public class Entry {

    private int field;

    public Entry() {
    }

    public Entry(int field) {
        this.field = field;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }
}
