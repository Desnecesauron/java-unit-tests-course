package br.com.desnecesauron.javaunittestscourse.person.integrationtests.controller;

import br.com.desnecesauron.javaunittestscourse.person.Person;
import br.com.desnecesauron.javaunittestscourse.person.config.TestConfigs;
import br.com.desnecesauron.javaunittestscourse.person.integrationtests.testcontainers.AbstractIntegrationTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PersonControllerIntegrationTest extends AbstractIntegrationTest {

    private static RequestSpecification requestSpecification;
    private static ObjectMapper objectMapper;
    private static Person person;

    @BeforeAll
    public static void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        requestSpecification = new RequestSpecBuilder().setBasePath("/person").setPort(TestConfigs.SERVER_PORT)
                                                       .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                                                       .addFilter(new ResponseLoggingFilter(LogDetail.ALL)).build();

        person = new Person("John", "Doe", "email@email.com", "Uberlandia - MG", "M");
    }

    @Order(1)
    @DisplayName("Integration test given person object when create one person then return a person object")
    @Test
    void integrationTestGivenPersonObject_When_CreateOnePerson_ShouldReturnAPersonObject() throws JsonProcessingException {

        String strSavedPerson = given().spec(requestSpecification).contentType(TestConfigs.CONTENT_TYPE_JSON)
                                       .body(person).when().post().then().statusCode(200).extract().body().asString();

        Person savedPerson = objectMapper.readValue(strSavedPerson, Person.class);

        assertNotNull(savedPerson);
        assertNotNull(savedPerson.getId());
        assertNotNull(savedPerson.getFirstName());
        assertNotNull(savedPerson.getLastName());
        assertNotNull(savedPerson.getEmail());
        assertNotNull(savedPerson.getAddress());
        assertNotNull(savedPerson.getGender());

        assertTrue(savedPerson.getId() > 0L);
        assertEquals(person.getFirstName(), savedPerson.getFirstName());
        assertEquals(person.getLastName(), savedPerson.getLastName());
        assertEquals(person.getEmail(), savedPerson.getEmail());
        assertEquals(person.getAddress(), savedPerson.getAddress());
        assertEquals(person.getGender(), savedPerson.getGender());

        person = savedPerson;
    }

}
