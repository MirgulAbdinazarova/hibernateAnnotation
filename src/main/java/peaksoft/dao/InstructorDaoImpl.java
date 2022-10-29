package peaksoft.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import peaksoft.Connection.DbConnection;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;

import java.util.List;

public class InstructorDaoImpl {

    private EntityManager entityManager = DbConnection.createEntityManager();

    public InstructorDaoImpl() {

    }

    public  void saveInstructorTable(Instructor instructor) {
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
    }

    public void updateInstructor(Instructor instructor,Long id) {
        try {
            entityManager.getTransaction().begin();
            Instructor instructor1 = entityManager.find(Instructor.class, id);
            instructor1.setFirstName(instructor.getFirstName());
            instructor1.setLastName(instructor.getLastName());
            instructor1.setEmail(instructor.getEmail());
            instructor1.setPhoneNumber(instructor.getPhoneNumber());
            entityManager.merge(instructor1);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Instructor updated!!!");
        }catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public  Instructor getInstructorById(Long id) {
        entityManager.getTransaction().begin();
       Instructor instructor = entityManager.find(Instructor.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor;
    }

    public Instructor getInstructorsByCourseId(Long courseId) {
        entityManager.getTransaction().begin();
       List<Instructor>instructors = entityManager.createQuery("select i from Instructor i", Instructor.class).getResultList();
        for (Instructor instructor:instructors) {
            for (int i = 0; i < instructor.getCourses().size(); i++) {
                if(instructor.getCourses().get(i).getId().equals(courseId)) {
                    return instructor;
                }
            }
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;

    }

    public  void deleteInstructorById(Long id) {
        entityManager.getTransaction().begin();
       Instructor instructor = entityManager.find(Instructor.class,id);
       entityManager.remove(instructor);
       entityManager.getTransaction().commit();
       entityManager.close();
    }

    public void  assignInstructorToCourse(Long instructorId,Long courseId) {

    }
}
