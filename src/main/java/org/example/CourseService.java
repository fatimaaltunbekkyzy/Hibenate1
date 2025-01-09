package org.example;

import org.example.entity.Course;

import java.util.List;

public interface CourseService{

    String saveCourse(Course course);

    Course getCourseById(Long id);

    String updateCourse(Long id,Course newCourse);

    List<Course> getAllCourses();

    String deleteCourse(Long id);
}
