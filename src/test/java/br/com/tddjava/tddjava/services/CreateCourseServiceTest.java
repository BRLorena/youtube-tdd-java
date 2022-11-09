package br.com.tddjava.tddjava.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

import br.com.tddjava.tddjava.modules.courses.entities.Course;
import br.com.tddjava.tddjava.modules.courses.repositories.CourseInMemoryRepository;
import br.com.tddjava.tddjava.modules.courses.services.CreateCourseService;

public class CreateCourseServiceTest {
  
  @Test //Aceptance testing
  public void should_be_able_to_create_a_new_course() {
    // Create a new course
    // Create table cursos (Entity)
    // ID, description, name, workload
    Course course = new Course();
    course.setDescription("Curso_description_Test");
    course.setName("Curso_Name");
    course.setWorkload(100);

    // Create a repository for course (db in memory for test)
    CourseInMemoryRepository repository = new CourseInMemoryRepository();

    // Create a new service
    CreateCourseService create_course = new CreateCourseService(repository);
    Course createdCourse = create_course.execute(course);
    
    // Assert to check
    assertNotNull(createdCourse.getId());
  }

  @Test(expected = Error.class)
  public void should_not_be_able_to_create_a_new_course_if_exists() {
    Course course = new Course();
    course.setDescription("Not_Create_Course");
    course.setName("Not_Create_Course");
    course.setWorkload(100);

    CourseInMemoryRepository repository = new CourseInMemoryRepository();

    CreateCourseService create_course = new CreateCourseService(repository);
    create_course.execute(course);
    create_course.execute(course);

  }
}
