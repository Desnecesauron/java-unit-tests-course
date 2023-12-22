package br.com.desnecesauron.javaunittestscourse.person.integrationtests.controller;

import br.com.desnecesauron.javaunittestscourse.person.Person;
import br.com.desnecesauron.javaunittestscourse.person.config.TestConfigs;
import br.com.desnecesauron.javaunittestscourse.person.integrationtests.testcontainers.AbstractIntegrationTest;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PersonControllerIntegrationTest extends AbstractIntegrationTest {

    private static RequestSpecification requestSpecification;
    private static ObjectMapper objectMapper;
    private static Person person;

    @BeforeAll
    public void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        requestSpecification = new RequestSpecBuilder().setBasePath("").setPort(TestConfigs.SERVER_PORT)
                                                       .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                                                       .addFilter(new ResponseLoggingFilter(LogDetail.ALL)).build();

        person = new Person("John", "Doe", "email@email.com", "Uberlandia - MG", "M");
    }

    @Test
    void test() {

    }

}
