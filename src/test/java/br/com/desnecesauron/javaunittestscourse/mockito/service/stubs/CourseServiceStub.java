package br.com.desnecesauron.javaunittestscourse.mockito.service.stubs;

import br.com.desnecesauron.javaunittestscourse.mockito.service.CourseService;

import java.util.Arrays;
import java.util.List;

public class CourseServiceStub implements CourseService {

    @Override
    public List<String> retrieveCourses(String student) {
        return Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
                "Kubernetes");
    }

    @Override
    public List<String> doSomething(String student) {
        return null;
    }

    @Override
    public void deleteCourse(String course) {

    }
    
}
