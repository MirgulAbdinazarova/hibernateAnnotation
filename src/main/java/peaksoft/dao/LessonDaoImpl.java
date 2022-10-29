package peaksoft.dao;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import peaksoft.Connection.DbConnection;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;

import java.util.List;

public class LessonDaoImpl {

    private EntityManager entityManager = DbConnection.createEntityManager();

    public LessonDaoImpl() {

    }

    public  void saveLessonTable(Lesson lesson,Long courseId) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        course.getLessons().add(lesson);
        lesson.setCourse(course);
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateLesson(Lesson lesson,Long id) {
        try {
            entityManager.getTransaction().begin();
            Lesson lesson1 = entityManager.find(Lesson.class, id);
            lesson1.setName(lesson.getName());
            entityManager.merge(lesson1);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Lesson updated!");
        } catch (EntityExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public Lesson getLessonById(Long id) {
        entityManager.getTransaction().begin();
       Lesson lesson = entityManager.find(Lesson.class,id);
       entityManager.getTransaction().commit();
       entityManager.close();
       return lesson;
    }

    public Lesson getLessonsByCourseId(Long courseId) {
        entityManager.getTransaction().begin();
       List<Lesson>lessons = entityManager.createQuery("select l from Lesson l", Lesson.class).getResultList();
        for (Lesson lesson:lessons) {
            if(lesson.getCourse().getId().equals(courseId)) {
                return lesson;
            }
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
        }
    }

