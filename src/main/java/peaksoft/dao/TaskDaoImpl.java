package peaksoft.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import peaksoft.Connection.DbConnection;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;

import java.util.List;

public class TaskDaoImpl {
    private EntityManager entityManager = DbConnection.createEntityManager();
    public TaskDaoImpl() {

    }

    public  void saveTaskTable(Task task,Long lessonId) {
        try {
            entityManager.getTransaction().begin();
            Lesson lesson = entityManager.find(Lesson.class, lessonId);
            task.setLesson(lesson);
            entityManager.persist(task);
            entityManager.getTransaction().commit();
            System.out.println("Task saved!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateTask(Task task,Long id) {
        try {
            entityManager.getTransaction().begin();
            Task task1 = entityManager.find(Task.class, id);
            task1.setName(task.getName());
            task1.setDeadLine(task.getDeadLine());
            task1.setTask(task.getTask());
            entityManager.merge(task1);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Task updated!");
        }catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public  Task getAllTaskByLessonId(Long lessonId) {
        entityManager.getTransaction().begin();
       List<Task> tasks = entityManager.createQuery("select t from Task t", Task.class).getResultList();
        for (Task task:tasks) {
            if(task.getLesson().getId().equals(lessonId)) {
               return task;
            }
        }
        entityManager.getTransaction().commit();
        return null;
    }

    public Task deleteTaskById(Long id) {
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class,id);
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        return task;
    }
}
