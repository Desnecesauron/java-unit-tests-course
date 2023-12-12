package br.com.desnecesauron.javaunittestscourse.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    IPersonService personService;
    Person person;

    @BeforeEach
    void setup() {
        personService = new PersonService();
        person = new Person("Keith", "Moon", "kmoon@gmail.com", "Wembley - UK", "Male");
    }

    @DisplayName("When create a person with success should return the object of the created person")
    @Test
    void testCreatePerson_WhenCreateAPersonWithSuccess_ShouldReturnTheObjectOfTheCreatedPerson() {
        // given
        // when
        Person actual = personService.createPerson(person);
        // then
        assertNotNull(actual, () -> "The created person is null!");
    }

    @DisplayName("When create a person with success should contain valid fields in returned object")
    @Test
    void testCreatedPerson_WhenSuccess_ShouldContainsValidFieldsInReturnedPersonObject() {
        // given
        // when
        Person actual = personService.createPerson(person);
        // then
        assertNotNull(person.getId(), () -> "The id is null!");
        assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The first name is not the same!");
        assertEquals(person.getLastName(), actual.getLastName(), () -> "The last name is not the same!");
        assertEquals(person.getEmail(), actual.getEmail(), () -> "The email is not the same!");
        assertEquals(person.getAddress(), actual.getAddress(), () -> "The address is not the same!");

    }

    @DisplayName("When create a person with null email should throw IllegalArgumentException")
    @Test
    void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException() {
        // given
        person.setEmail(null);
        // when & then

        // verify thrown message
        // verify thrown exception
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> personService.createPerson(person),
                () -> "The email being null should throw IllegalArgumentException!");
        assertEquals("The Person email is null!", exception.getMessage());
    }

}
