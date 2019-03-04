package ru.job4j.xml;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 04.03.2019
 */
@XmlRootElement
public class Entity {

    private List<Entry> entry;

    public Entity() {
    }

    public Entity(List<Entry> entry) {
        this.entry = entry;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }
}