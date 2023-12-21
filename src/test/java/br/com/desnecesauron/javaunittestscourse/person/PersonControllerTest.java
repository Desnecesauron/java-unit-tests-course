package br.com.desnecesauron.javaunittestscourse.person;

import br.com.desnecesauron.javaunittestscourse.exceptions.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PersonServices personServices;

    private Person person;

    @BeforeEach
    void setup() {
        person = new Person("Keith", "Moon", "kmoon@gmail.com", "Wembley - UK", "Male");
    }

    @DisplayName("Test Given Person Object When Create Person Then Return Saved Person Object")
    @Test
    void testGivenPersonObject_WhenCreatePerson_ThenReturnSavedPersonObject() throws Exception {

        given(personServices.create(any(Person.class))).willAnswer((invocation) -> invocation.getArgument(0));

        ResultActions resultActions = mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON)
                                                                     .content(objectMapper.writeValueAsString(person)));

        resultActions.andDo(print()).andExpect(status().isOk())
                     .andExpect(jsonPath("$.firstName").value(person.getFirstName()))
                     .andExpect(jsonPath("$.lastName").value(person.getLastName()))
                     .andExpect(jsonPath("$.email").value(person.getEmail()));

    }

    @DisplayName("Test Given List Of Persons When Find All Persons Then Return Persons List")
    @Test
    void testGivenListOfPersons_WhenFindAllPersons_ThenReturnPersonsList() throws Exception {

        List<Person> persons = new ArrayList<>();
        persons.add(person);
        persons.add(new Person("Leopardo", "Costa", "leopardo@costa.com.br", "Cidade dos Uber (Uberlândia)", "M"));

        given(personServices.findAll()).willReturn(persons);

        ResultActions resultActions = mockMvc.perform(get("/person").content(objectMapper.writeValueAsString(person)));

        resultActions.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.size()").value(persons.size()));

    }

    @DisplayName("Test Given Person Id When Find By Id Then Return Person Object")
    @Test
    void testGivenPersonId_WhenFindById_ThenReturnPersonObject() throws Exception {

        long personId = 1L;
        given(personServices.findById(personId)).willReturn(person);

        ResultActions resultActions = mockMvc.perform(get("/person/{id}", personId));

        resultActions.andDo(print()).andExpect(status().isOk())
                     .andExpect(jsonPath("$.firstName").value(person.getFirstName()))
                     .andExpect(jsonPath("$.lastName").value(person.getLastName()))
                     .andExpect(jsonPath("$.email").value(person.getEmail()));
    }

    @DisplayName("Test Given Invalid Person Id When Find By Id Then Return Not Found")
    @Test
    void testGivenInvalidPersonId_WhenFindById_ThenReturnNotFound() throws Exception {

        long personId = 1L;
        given(personServices.findById(personId)).willThrow(ResourceNotFoundException.class);

        ResultActions resultActions = mockMvc.perform(get("/person/{id}", personId));

        resultActions.andDo(print()).andExpect(status().isNotFound());
    }

    @DisplayName("Test Given Updated Person Object When Update Person Then Return Updated Person Object")
    @Test
    void testGivenUpdatedPersonObject_WhenUpdatePerson_ThenReturnUpdatedPersonObject() throws Exception {

        long personId = 1L;
        given(personServices.findById(personId)).willReturn(person);
        given(personServices.update(any(Person.class))).willAnswer((invocation) -> invocation.getArgument(0));

        Person updatedPerson = new Person("Leopardo", "Costa", "leopardo@costa.com.br", "Cidade dos Uber (Uberlândia)",
                "M");


        ResultActions resultActions = mockMvc.perform(put("/person").contentType(MediaType.APPLICATION_JSON).content(
                objectMapper.writeValueAsString(updatedPerson)));

        resultActions.andDo(print()).andExpect(status().isOk())
                     .andExpect(jsonPath("$.firstName").value(updatedPerson.getFirstName()))
                     .andExpect(jsonPath("$.lastName").value(updatedPerson.getLastName()))
                     .andExpect(jsonPath("$.email").value(updatedPerson.getEmail()));

    }
}
