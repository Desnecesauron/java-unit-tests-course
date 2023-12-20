package br.com.desnecesauron.javaunittestscourse.person;

import br.com.desnecesauron.javaunittestscourse.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

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

    @DisplayName("Test Given Existing Email When Save Person Then Throws Exception")
    @Test
    void testGivenExistingEmail_WhenSavePerson_ThenThrowsException() {

        given(personRepository.findByEmail(anyString())).willReturn(Optional.of(person));

        assertThrows(ResourceNotFoundException.class, () -> personServices.create(person));

        verify(personRepository, never()).save(any(Person.class));

    }

    @DisplayName("Test Given Persons List When Find All Persons Then Return Persons List")
    @Test
    void testGivenPersonsList_WhenFindAllPersons_ThenReturnPersonsList() {
        Person person1 = new Person("Johnzinho", "Doezão", "email1@email1.com", "Lavras - MG", "M");
        given(personRepository.findAll()).willReturn(List.of(person, person1));

        List<Person> persons = personServices.findAll();

        assertNotNull(persons);
        assertEquals(2, persons.size());

    }

    @DisplayName("Test Given Empty Persons List When Find All Persons Then Return Empty Persons List")
    @Test
    void testGivenEmptyPersonsList_WhenFindAllPersons_ThenReturnEmptyPersonsList() {
        given(personRepository.findAll()).willReturn(Collections.emptyList());

        List<Person> persons = personServices.findAll();

        assertTrue(persons.isEmpty());
        assertEquals(0, persons.size());

    }

    @DisplayName("Test Given Person Id When FindById Then Return Person Object")
    @Test
    void testGivenPersonId_WhenFindById_ThenReturnPersonObject() {

        given(personRepository.findById(anyLong())).willReturn(Optional.of(person));

        Person savedPerson = personServices.findById(1L);

        assertNotNull(savedPerson);
        assertEquals(person.getFirstName(), savedPerson.getFirstName());

    }

    @DisplayName("Test Given Person Object When update Person Then Return updated Person Object")
    @Test
    void testGivenPersonObject_WhenUpdatePerson_ThenReturnUpdatedPersonObject() {

        person.setId(1L);
        given(personRepository.findById(anyLong())).willReturn(Optional.of(person));

        person.setFirstName("Jonas");
        person.setEmail("jonas@jonas.com");

        given(personRepository.save(person)).willReturn(person);

        Person updatedPerson = personServices.update(person);

        assertNotNull(updatedPerson);
        assertEquals(person.getFirstName(), updatedPerson.getFirstName());
        assertEquals(person.getEmail(), updatedPerson.getEmail());
    }

    @DisplayName("Test Given Person ID When Delete Person Then Do Nothing")
    @Test
    void testGivenPersonID_WhenDeletePerson_ThenDoNothing() {

        person.setId(1L);
        given(personRepository.findById(anyLong())).willReturn(Optional.of(person));
        willDoNothing().given(personRepository).delete(person);

        personServices.delete(person.getId());

        verify(personRepository, times(1)).delete(person);
    }

}
