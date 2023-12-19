package br.com.desnecesauron.javaunittestscourse.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class PersonServicesTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServices personServices;

    private Person person;

    @BeforeEach
    void setup() {
        person = new Person("Keith", "Moon", "kmoon@gmail.com", "Wembley - UK", "Male");
    }

    @DisplayName("Test Given Person Object When Save Person Then Return Person Object")
    @Test
    void testGivenPersonObject_WhenSavePerson_ThenReturnPersonObject() {

        given(personRepository.findByEmail(anyString())).willReturn(Optional.empty());
        given(personRepository.save(person)).willReturn(person);

        Person savedPerson = personServices.create(person);

        assertNotNull(savedPerson);
        assertEquals(person.getFirstName(), savedPerson.getFirstName());

    }

}
