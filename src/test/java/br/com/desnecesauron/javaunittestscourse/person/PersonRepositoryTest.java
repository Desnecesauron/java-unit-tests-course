package br.com.desnecesauron.javaunittestscourse.person;

import br.com.desnecesauron.javaunittestscourse.person.integrationtests.testcontainers.AbstractIntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersonRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private PersonRepository personRepository;

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person("John", "Doe", "email@email.com", "Uberlandia - MG", "M");
    }

    @DisplayName("Given person object when save then return saved person")
    @Test
    void testGivenPersonObjectWhenSaveThenReturnSavedPerson() {

        Person savedPerson = personRepository.save(person);

        assertNotNull(savedPerson);
        assertTrue(savedPerson.getId() > 0L);

    }

    @DisplayName("Given person list when find all then return person list")
    @Test
    void testGivenPersonList_WhenFindAll_ThenReturnPersonList() {

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

        personRepository.save(person);

        Person personFound = personRepository.findById(person.getId()).orElse(null);

        assertNotNull(personFound);
        assertEquals(person.getId(), personFound.getId());

    }

    @DisplayName("Given person list when find by email then return person object")
    @Test
    void testGivenPersonObject_WhenFindByEmail_ThenReturnPersonObject() {

        personRepository.save(person);

        Person personFound = personRepository.findByEmail(person.getEmail()).orElse(null);

        assertNotNull(personFound);
        assertEquals(person.getId(), personFound.getId());

    }

    @DisplayName("Given person object when update person then return updated person object")
    @Test
    void testGivenPersonObject_WhenUpdatedPerson_ThenReturnUpdatedPersonObject() {

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

        personRepository.save(person);

        personRepository.deleteById(person.getId());

        Optional<Person> personFound = personRepository.findById(person.getId());

        assertTrue(personFound.isEmpty());

    }


    @DisplayName("Given person object when find by JPQL then return person object")
    @Test
    void testGivenFirstNameAndLastName_WhenFindByJPQL_ThenReturnPersonObject() {

        personRepository.save(person);

        Person personFound = personRepository.findByJPQL(person.getFirstName(), person.getLastName());

        assertNotNull(personFound);
        assertEquals(person.getId(), personFound.getId());
        assertEquals(person.getFirstName(), personFound.getFirstName());
        assertEquals(person.getLastName(), personFound.getLastName());

    }

    @DisplayName("Given person object when find by JPQL NAMED Parameters then return person object")
    @Test
    void testGivenFirstNameAndLastName_WhenFindByJPQLNamedParameters_ThenReturnPersonObject() {

        personRepository.save(person);

        Person personFound = personRepository.findByJPQLNamedParameters(person.getFirstName(), person.getLastName());

        assertNotNull(personFound);
        assertEquals(person.getId(), personFound.getId());
        assertEquals(person.getFirstName(), personFound.getFirstName());
        assertEquals(person.getLastName(), personFound.getLastName());

    }

    @DisplayName("Given person object when find by Native SQL then return person object")
    @Test
    void testGivenFirstNameAndLastName_WhenFindByNativeSQL_ThenReturnPersonObject() {

        personRepository.save(person);

        Person personFound = personRepository.findByNativeSQL(person.getFirstName(), person.getLastName());

        assertNotNull(personFound);
        assertEquals(person.getId(), personFound.getId());
        assertEquals(person.getFirstName(), personFound.getFirstName());
        assertEquals(person.getLastName(), personFound.getLastName());

    }

    @DisplayName("Given person object when find by Native SQL NAMED Parameters then return person object")
    @Test
    void testGivenFirstNameAndLastName_WhenFindByNativeSQLWithNamedParameters_ThenReturnPersonObject() {

        personRepository.save(person);

        Person personFound = personRepository.findByNativeSQLWithNamedParameters(person.getFirstName(),
                person.getLastName());

        assertNotNull(personFound);
        assertEquals(person.getId(), personFound.getId());
        assertEquals(person.getFirstName(), personFound.getFirstName());
        assertEquals(person.getLastName(), personFound.getLastName());

    }

}
