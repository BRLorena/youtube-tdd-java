package br.com.tddjava.tddjava.modules.courses.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tddjava.tddjava.modules.courses.entities.Course;
import br.com.tddjava.tddjava.modules.courses.repositories.IcourseRepository;

@Service
public class CreateCourseService {
  
  private IcourseRepository repository;

  public CreateCourseService(IcourseRepository repository ){
    this.repository = repository;
  }

  public Course execute(Course course){

    // validate if course exist by name
    Course existedCourse = this.repository.findByName(course.getName());
    
    // If exist - return erro
    if(existedCourse != null){

      throw new Error("The course already exist!");
    }

    // If not exist - save and return new course
    return this.repository.save(course);
  }
}
