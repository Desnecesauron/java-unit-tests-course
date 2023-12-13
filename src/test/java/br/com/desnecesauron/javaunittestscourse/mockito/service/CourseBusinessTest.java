package br.com.desnecesauron.javaunittestscourse.mockito.service;

import br.com.desnecesauron.javaunittestscourse.mockito.service.stubs.CourseServiceStub;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseBusinessTest {

    @Test
    void testCoursesRelatedToSpring_When_UsingAStub() {
        // Given / Arrange
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);
        // When / Act
        List<String> stringList = business.retrieveCoursesRelatedToSpring("Cesar");
        // Then / Assert
        assertEquals(2, stringList.size());
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAFooBarStudent() {
        // Given / Arrange
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);
        // When / Act
        List<String> stringList = business.retrieveCoursesRelatedToSpring("Foo Bar");
        // Then / Assert
        assertEquals(0, stringList.size());
    }

}
