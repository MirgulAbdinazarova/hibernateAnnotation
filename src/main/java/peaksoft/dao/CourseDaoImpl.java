package peaksoft.dao;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import peaksoft.Connection.DbConnection;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.entity.Lesson;

import java.util.List;

public class CourseDaoImpl {

    private EntityManager entityManager = DbConnection.createEntityManager();

    public CourseDaoImpl() {

    }


    public void saveCourse(Course course) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            System.out.println("Course saved successfully");
        } catch (EntityExistsException e) {
            System.out.println(e.getMessage());
        }

    }

    public Course getCourseById(Long id) {

          entityManager.getTransaction().begin();
          Course course = entityManager.find(Course.class, id);
          entityManager.getTransaction().commit();
          entityManager.close();
          return course;
      }

    public List<Course> getAllCourses() {
        List<Course> courses = entityManager.createQuery("select c from Course c", Course.class).getResultList();
        return courses;
    }

    public void updateCourse(Course course,Long id) {
        try {
            entityManager.getTransaction().begin();
            Course course1 = entityManager.find(Course.class, id);
            course1.setCourseName(course.getCourseName());
            course1.setCreateAt(course.getCreateAt());
            course1.setDescription(course.getDescription());
            course1.setImageLink(course.getImageLink());
            course1.setDuration(course.getDuration());
            entityManager.merge(course1);
            entityManager.getTransaction().commit();
            System.out.println("Course updated!");
        }catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteCourseById(Long id) {

        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
        entityManager.getTransaction().commit();

    }

    public Course getCourseByName(String name) {
        entityManager.getTransaction().begin();
      List<Course>courses = entityManager.createQuery("select c from Course c", Course.class).getResultList();
        for (Course i: courses) {
            if (i.getCourseName().equals(name)){
                return i;
            }
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }
}