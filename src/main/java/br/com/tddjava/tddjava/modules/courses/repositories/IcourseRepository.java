package br.com.tddjava.tddjava.modules.courses.repositories;

import br.com.tddjava.tddjava.modules.courses.entities.Course;

public interface IcourseRepository {

  public Course findByName(String name);
  public Course save(Course course);
}
