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

import java.util.Arrays;
import java.util.List;

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

    @Order(2)
    @DisplayName("Integration test given person object when update one person then return a person object")
    @Test
    void integrationTestGivenPersonObject_When_UpdateOnePerson_ShouldReturnAPersonObject() throws JsonProcessingException {

        person.setFirstName("Johnzinho");
        person.setLastName("Doezão");
        person.setEmail("john@gmail.com");


        String strSavedPerson = given().spec(requestSpecification).contentType(TestConfigs.CONTENT_TYPE_JSON)
                                       .body(person).when().put().then().statusCode(200).extract().body().asString();

        Person updatedPerson = objectMapper.readValue(strSavedPerson, Person.class);

        assertNotNull(updatedPerson);
        assertNotNull(updatedPerson.getId());
        assertNotNull(updatedPerson.getFirstName());
        assertNotNull(updatedPerson.getLastName());
        assertNotNull(updatedPerson.getEmail());
        assertNotNull(updatedPerson.getAddress());
        assertNotNull(updatedPerson.getGender());

        assertTrue(updatedPerson.getId() > 0L);
        assertEquals(person.getFirstName(), updatedPerson.getFirstName());
        assertEquals(person.getLastName(), updatedPerson.getLastName());
        assertEquals(person.getEmail(), updatedPerson.getEmail());
        assertEquals(person.getAddress(), updatedPerson.getAddress());
        assertEquals(person.getGender(), updatedPerson.getGender());

        person = updatedPerson;
    }

    @Order(3)
    @DisplayName("Integration test given person object when find by one person then return a person object")
    @Test
    void integrationTestGivenPersonObject_When_FindById_ShouldReturnAPersonObject() throws JsonProcessingException {

        String strSavedPerson = given().spec(requestSpecification).pathParam("id", person.getId()).when().get("{id}")
                                       .then().statusCode(200).extract().body().asString();

        Person foundPerson = objectMapper.readValue(strSavedPerson, Person.class);

        assertNotNull(foundPerson);
        assertNotNull(foundPerson.getId());
        assertNotNull(foundPerson.getFirstName());
        assertNotNull(foundPerson.getLastName());
        assertNotNull(foundPerson.getEmail());
        assertNotNull(foundPerson.getAddress());
        assertNotNull(foundPerson.getGender());

        assertTrue(foundPerson.getId() > 0L);
        assertEquals(person.getFirstName(), foundPerson.getFirstName());
        assertEquals(person.getLastName(), foundPerson.getLastName());
        assertEquals(person.getEmail(), foundPerson.getEmail());
        assertEquals(person.getAddress(), foundPerson.getAddress());
        assertEquals(person.getGender(), foundPerson.getGender());
    }

    @Order(4)
    @DisplayName("Integration test given person object when findAll persons then return a persons list")
    @Test
    void integrationTest_When_FindAll_ShouldReturnAPersonsList() throws JsonProcessingException {

        Person person1 = new Person("Joanes", "Burgo", "email1@email1.com", "Lavras - MG", "M");

        String strSecondSavedPerson = given().spec(requestSpecification).contentType(TestConfigs.CONTENT_TYPE_JSON)
                                             .body(person1).when().post().then().statusCode(200).extract().body()
                                             .asString();

        String strFindAll = given().spec(requestSpecification).when().get().then().statusCode(200).extract().body()
                                   .asString();

        List<Person> foundPersons = Arrays.asList(objectMapper.readValue(strFindAll, Person[].class));

        assertNotNull(foundPersons);
        assertEquals(2, foundPersons.size());

        Person foundPerson = foundPersons.get(0);

        assertNotNull(foundPerson.getId());
        assertNotNull(foundPerson.getFirstName());
        assertNotNull(foundPerson.getLastName());
        assertNotNull(foundPerson.getEmail());
        assertNotNull(foundPerson.getAddress());
        assertNotNull(foundPerson.getGender());

        assertTrue(foundPerson.getId() > 0L);
        assertEquals(person.getFirstName(), foundPerson.getFirstName());
        assertEquals(person.getLastName(), foundPerson.getLastName());
        assertEquals(person.getEmail(), foundPerson.getEmail());
        assertEquals(person.getAddress(), foundPerson.getAddress());
        assertEquals(person.getGender(), foundPerson.getGender());

        Person foundPerson1 = foundPersons.get(1);

        assertNotNull(foundPerson1.getId());
        assertNotNull(foundPerson1.getFirstName());
        assertNotNull(foundPerson1.getLastName());
        assertNotNull(foundPerson1.getEmail());
        assertNotNull(foundPerson1.getAddress());
        assertNotNull(foundPerson1.getGender());

        assertTrue(foundPerson1.getId() > 0L);
        assertEquals(person1.getFirstName(), foundPerson1.getFirstName());
        assertEquals(person1.getLastName(), foundPerson1.getLastName());
        assertEquals(person1.getEmail(), foundPerson1.getEmail());
        assertEquals(person1.getAddress(), foundPerson1.getAddress());
        assertEquals(person1.getGender(), foundPerson1.getGender());
    }

}
