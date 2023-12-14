package br.com.desnecesauron.javaunittestscourse.mockito.service;

import br.com.desnecesauron.javaunittestscourse.mockito.service.CourseService;

import java.util.ArrayList;
import java.util.List;

// System (Method) under test (SUT)
public class CourseBusiness {

    // Dependency
    private CourseService courseService;

    public CourseBusiness(CourseService courseService) {
        this.courseService = courseService;
    }

    public List<String> retrieveCoursesRelatedToSpring(String student) {
        List<String> courses = courseService.retrieveCourses(student);
        if ("Foo Bar".equals(student)) {
            return new ArrayList<>();
        }
        List<String> filteredCourses = new ArrayList<>(courses);
        filteredCourses.removeIf(course -> !course.contains("Spring"));
        return filteredCourses;
    }

    public void deleteCoursesNotRelatedToSpring(String student) {
        List<String> courses = courseService.retrieveCourses(student);

        for (String course : courses) {
            if (!course.contains("Spring")) {
                courseService.deleteCourse(course);
            }
        }
    }


}
