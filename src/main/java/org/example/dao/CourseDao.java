package org.example.dao;

import org.example.entity.Course;

import java.util.List;

public interface CourseDao {

    String saveCourse(Course course);

    Course getCourseById(Long id);

    String updateCourse(Long id,Course newCourse);

    List<Course> getAllCourses();

    String deleteCourse(Long id);
}
