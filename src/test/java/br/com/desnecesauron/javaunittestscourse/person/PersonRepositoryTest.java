package br.com.desnecesauron.javaunittestscourse.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

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

    @DisplayName("Given person object when update person then return updated person object")
    @Test
    void testGivenPersonObject_WhenUpdatedPerson_ThenReturnUpdatedPersonObject() {

        Person person = new Person("John", "Doe", "email@email.com", "Uberlandia - MG", "M");

        personRepository.save(person);

        Person personFound = personRepository.findById(person.getId()).orElse(null);
        personFound.setFirstName("Johnzinho");
        personFound.setLastName("Doezão");
        personFound.setEmail("email@emailAlterado.com");

        Person personUpdated = personRepository.save(personFound);

        assertNotNull(personUpdated);
        assertEquals(personFound.getId(), personUpdated.getId());
        assertEquals(personFound.getFirstName(), personUpdated.getFirstName());

    }

    @DisplayName("Given person object when delete then remove person")
    @Test
    void testGivenPersonObject_WhenDelete_ThenRemovePerson() {

        Person person = new Person("John", "Doe", "email@email.com", "Uberlandia - MG", "M");

        personRepository.save(person);

        personRepository.deleteById(person.getId());

        Optional<Person> personFound = personRepository.findById(person.getId());

        assertTrue(personFound.isEmpty());

    }


    @DisplayName("Given person object when find by JPQL then return person object")
    @Test
    void testGivenFirstNameAndLastName_WhenFindByJPQL_ThenReturnPersonObject() {

        Person person = new Person("John", "Doe", "email@email.com", "Uberlandia - MG", "M");

        personRepository.save(person);

        Person personFound = personRepository.findByJPQL(person.getFirstName(), person.getLastName());

        assertNotNull(personFound);
        assertEquals(person.getId(), personFound.getId());
        assertEquals(person.getFirstName(), personFound.getFirstName());
        assertEquals(person.getLastName(), personFound.getLastName());

    }

}
