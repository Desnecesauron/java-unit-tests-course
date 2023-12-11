package br.com.desnecesauron.javaunittestscourse.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonServiceTest {

    Person person;

    @BeforeEach
    void setup() {
        person = new Person("Keith", "Moon", "kmoon@gmail.com", "Wembley - UK", "Male");
    }

    @DisplayName("When create a person with success should return the object of the created person")
    @Test
    void testCreatePerson_WhenCreateAPersonWithSuccess_ShouldReturnTheObjectOfTheCreatedPerson() {
        // given
        IPersonService personService = new PersonService();
        // when
        Person actual = personService.createPerson(person);
        // then
        assertNotNull(actual, () -> "The created person is null!");
    }

    @DisplayName("When create a person with success should should contain first name in returned object")
    @Test
    void testCreatedPerson_WhenSuccess_ShouldContainsFirstNameInReturnedPersonObject() {
        // given
        IPersonService personService = new PersonService();
        // when
        Person actual = personService.createPerson(person);
        // then
        assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The first name is not the same!");

    }

}
