package br.com.desnecesauron.javaunittestscourse.person;

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

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

}
