package br.com.desnecesauron.javaunittestscourse.person;

import java.util.concurrent.atomic.AtomicLong;

public class PersonService implements IPersonService {
    @Override
    public Person createPerson(Person person) {
        Long id = new AtomicLong().incrementAndGet();
        person.setId(id);
        return person;
    }
}
