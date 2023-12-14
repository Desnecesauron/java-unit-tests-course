package br.com.desnecesauron.javaunittestscourse.mockito.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class CourseBusinessMockWithBDDTest {

    CourseService mockService;
    CourseBusiness business;
    List<String> listCourses;

    @BeforeEach
    void setUp() {
        // Given / Arrange
        mockService = mock(CourseService.class);
        business = new CourseBusiness(mockService);
        listCourses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
                "Kubernetes");
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAMock() {
        // Given / Arrange
        given(mockService.retrieveCourses("Cesar")).willReturn(listCourses);
        // When / Act
        List<String> stringList = business.retrieveCoursesRelatedToSpring("Cesar");
        // Then / Assert
        assertThat(stringList.size(), is(2));
    }

    @DisplayName("Delete courses not related to spring using mockito should call method deleteCourse()")
    @Test
    void testDeleteCoursesNotRelatedToSpring_When_UsingMockitoVerify_Should_CallMethod_deleteCourse() {
        // Given / Arrange
        given(mockService.retrieveCourses("Cesar")).willReturn(listCourses);
        // When / Act
        business.deleteCoursesNotRelatedToSpring("Cesar");
        // Then / Assert

        // verify if the method deleteCourse() was called with the argument "Microservices"
        verify(mockService).deleteCourse("Microservices");
        // verify if the method deleteCourse() was called with the argument "API"
        // the times() method is used to verify how many times the method was called
        verify(mockService, times(1)).deleteCourse("API");
        // verify if the method deleteCourse() was called with the argument "AWS"
        // the atLeast() method is used to verify if the method was called at least one time
        verify(mockService, atLeast(1)).deleteCourse("Kubernetes");
        // verify if the method deleteCourse() was called with the argument "PCF"
        // the atLeastOnce() method is used to verify if the method was called at least one time
        verify(mockService, atLeastOnce()).deleteCourse("Kubernetes");
        // verify if the method deleteCourse() was called with the argument "Azure"
        // the atMost() method is used to verify if the method was called at most one time
        verify(mockService, atMost(1)).deleteCourse("Kubernetes");
    }


    @DisplayName("Delete courses not related to spring using mockito should call method deleteCourse() V2")
    @Test
    void testDeleteCoursesNotRelatedToSpring_When_UsingMockitoVerify_Should_CallMethod_deleteCourseV2() {
        // Given / Arrange
        given(mockService.retrieveCourses("Cesar")).willReturn(listCourses);
        // When / Act
        business.deleteCoursesNotRelatedToSpring("Cesar");
        // Then / Assert

        then(mockService).should().deleteCourse("Microservices");
        // never() method is used to verify if the method was never called
        then(mockService).should(never()).deleteCourse("Spring");
        then(mockService).should(times(1)).deleteCourse("API");
        then(mockService).should(atLeast(1)).deleteCourse("Kubernetes");
        then(mockService).should(atLeastOnce()).deleteCourse("Kubernetes");
        then(mockService).should(atMost(1)).deleteCourse("Kubernetes");
    }


}
