package org.example;

import org.example.dao.CourseDao;
import org.example.impl.CourseDaoImpl;
import org.example.entity.Course;

import java.util.List;

public class CourseServiceImpl implements CourseService{
    CourseDao courseDao=new CourseDaoImpl();
    @Override
    public String saveCourse(Course course) {
        return courseDao.saveCourse(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public String updateCourse(Long id, Course newCourse) {
        return courseDao.updateCourse(id,newCourse);
    }

    @Override
    public List<Course> getAllCourses() {
        return null;
    }

    @Override
    public String deleteCourse(Long id) {
        return "";
    }
}
