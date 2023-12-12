package br.com.desnecesauron.javaunittestscourse;

import br.com.desnecesauron.javaunittestscourse.mockito.service.CourseService;

import java.util.List;

// System (Method) under test (SUT)
public class CourseBusiness {

    // Dependency
    private CourseService courseService;

    public CourseBusiness(CourseService courseService) {
        this.courseService = courseService;
    }

    public List<String> retrieveCoursesRelatedToSpring(String student) {
        List<String> filteredCourses = courseService.retrieveCourses(student);
        filteredCourses.removeIf(course -> !course.contains("Spring"));
        return filteredCourses;
    }


}
