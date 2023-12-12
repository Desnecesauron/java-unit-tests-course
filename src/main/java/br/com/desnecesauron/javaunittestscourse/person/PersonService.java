package br.com.desnecesauron.javaunittestscourse.person;

import java.util.concurrent.atomic.AtomicLong;

public class PersonService implements IPersonService {

    @Override
    public Person createPerson(Person person) {
        if (person.getEmail() == null || person.getEmail().isBlank() || person.getEmail().isEmpty()) {
            throw new IllegalArgumentException("The Person email is null!");
        }
        Long id = new AtomicLong().incrementAndGet();
        person.setId(id);
        return person;
    }

}
