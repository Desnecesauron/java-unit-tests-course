package br.com.desnecesauron.javaunittestscourse.mockito.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CourseBusinessMockTest {

    CourseService mockService;
    CourseBusiness business;

    @BeforeEach
    void setUp() {
        // Given / Arrange
        mockService = mock(CourseService.class);
        business = new CourseBusiness(mockService);
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAMock() {
        // When / Act
        List<String> stringList = business.retrieveCoursesRelatedToSpring("Cesar");
        // Then / Assert
        assertEquals(2, stringList.size());
    }


}
