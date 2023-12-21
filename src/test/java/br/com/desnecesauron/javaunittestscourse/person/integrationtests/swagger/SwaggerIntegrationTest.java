package br.com.desnecesauron.javaunittestscourse.person.integrationtests.swagger;

import br.com.desnecesauron.javaunittestscourse.person.config.TestConfigs;
import br.com.desnecesauron.javaunittestscourse.person.integrationtests.testcontainers.AbstractIntegrationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest extends AbstractIntegrationTest {


    @DisplayName("Should display Swagger UI page")
    @Test
    public void testShouldDisplauSwaggerUiPage() {
        String string = given().basePath("/swagger-ui/index.html").port(TestConfigs.SERVER_PORT).when().get().then()
                               .statusCode(200).extract().body().asString();

        assertTrue(string.contains("Swagger UI"));
    }

}
