package br.com.desnecesauron.javaunittestscourse.person;

public class PersonService implements IPersonService {
    @Override
    public Person createPerson(Person person) {
        return new Person();
    }
}
