package org.example;

import org.example.config.HibernateConfig;
import org.example.entity.Course;
import org.example.enums.StudyFormat;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
//        HibernateConfig.getEntityManager();
CourseService courseService = new CourseServiceImpl();
        System.out.println(courseService.saveCourse(new Course("Js", 12000, StudyFormat.OFFLINE)));
        System.out.println(courseService.getCourseById(2L));
        System.out.println(courseService.updateCourse(2L, new Course("C++", 10000, StudyFormat.OFFLINE)));
        System.out.println(courseService.getAllCourses());
        System.out.println(courseService.deleteCourse(2L));

    }
}
