package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since
 */
public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("tr");
        assertThat(persons.iterator().next().getName(), is("Petr"));
    }
}

