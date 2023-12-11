package br.com.desnecesauron.javaunittestscourse.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonServiceTest {

    @DisplayName("When create a person with success should return the object of the created person")
    @Test
    void testCreatePerson_WhenCreateAPersonWithSuccess_ShouldReturnTheObjectOfTheCreatedPerson() {
        // given
        IPersonService personService = new PersonService();

        Person person = new Person("Keith", "Moon", "kmoon@gmail.com", "Wembley - UK", "Male");
        // when
        Person actual = personService.createPerson(person);
        // then
        assertNotNull(actual, () -> "The created person is null!");
    }

}
