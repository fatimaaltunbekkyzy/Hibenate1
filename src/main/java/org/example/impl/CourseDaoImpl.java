package org.example.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.dao.CourseDao;
import org.example.entity.Course;
import org.hibernate.HibernateException;

import java.util.List;

public class CourseDaoImpl implements CourseDao {
EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManager();
    @Override
    public String saveCourse(Course course) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            return "success";
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return "failed";
    }

    @Override
    public Course getCourseById(Long id) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            //Course course =  entityManager.find(Course.class,id);
            Course course=entityManager.createQuery("select c from Course c where c.id =:id",Course.class)
                    .setParameter("id",id).getSingleResult();
            entityManager.getTransaction().commit();
            return course;
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateCourse(Long id, Course newCourse) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            Course course=entityManager.find(Course.class, id);
            course.setName(newCourse.getName());
            course.setPrice(newCourse.getPrice());
            course.setStudyFormat(newCourse.getStudyFormat());
            entityManager.merge(course);
            entityManager.getTransaction().commit();
            return "success update";
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return "update filed";
    }

    @Override
    public List<Course> getAllCourses() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            List<Course> courses = entityManager.createQuery("select c from Course c", Course.class).getResultList();
            entityManager.getTransaction().commit();
            return courses;
        } catch (Exception e) {
            System.out.println("Ката: " + e.getMessage());
        }

        return null;
    }

    @Override
    public String deleteCourse(Long id) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            Course course=entityManager.find(Course.class, id);
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            return "success delete";
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }
        return "delete filed";
    }
}
