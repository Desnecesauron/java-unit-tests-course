package br.com.desnecesauron.javaunittestscourse.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @DisplayName("Given person object when save then return saved person")
    @Test
    void testGivenPersonObjectWhenSaveThenReturnSavedPerson() {

        Person person = new Person("John", "Doe", "email@email.com", "Uberlandia - MG", "M");

        Person savedPerson = personRepository.save(person);

        assertNotNull(savedPerson);
        assertTrue(savedPerson.getId() > 0L);

    }

    @DisplayName("Given person list when find all then return person list")
    @Test
    void testGivenPersonList_WhenFindAll_ThenReturnPersonList() {

        Person person = new Person("John", "Doe", "email@email.com", "Uberlandia - MG", "M");
        Person person1 = new Person("Johnzinho", "Doezão", "email1@email1.com", "Lavras - MG", "M");

        personRepository.save(person);
        personRepository.save(person1);

        List<Person> personList = personRepository.findAll();

        assertNotNull(personList);
        assertEquals(2, personList.size());

    }

    @DisplayName("Given person list when find by id then return person object")
    @Test
    void testGivenPersonObject_WhenFindById_ThenReturnPersonObject() {

        Person person = new Person("John", "Doe", "email@email.com", "Uberlandia - MG", "M");

        personRepository.save(person);

        Person personFound = personRepository.findById(person.getId()).orElse(null);

        assertNotNull(personFound);
        assertEquals(person.getId(), personFound.getId());

    }

    @DisplayName("Given person list when find by email then return person object")
    @Test
    void testGivenPersonObject_WhenFindByEmail_ThenReturnPersonObject() {

        Person person = new Person("John", "Doe", "email@email.com", "Uberlandia - MG", "M");

        personRepository.save(person);

        Person personFound = personRepository.findByEmail(person.getEmail()).orElse(null);

        assertNotNull(personFound);
        assertEquals(person.getId(), personFound.getId());

    }

}
