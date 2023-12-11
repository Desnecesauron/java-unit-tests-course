package br.com.desnecesauron.javaunittestscourse.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

    @DisplayName("When create a person with success should return the object of the created person")
    @Test
    void testCreatePerson_WhenCreateAPersonWithSuccess_ShouldReturnTheObjectOfTheCreatedPerson() {
        // given
        IPersonService personService = new PersonService();
        // when

        // then
    }

}
