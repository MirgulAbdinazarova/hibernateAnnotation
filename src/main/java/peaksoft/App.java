package peaksoft;

import peaksoft.dao.CourseDaoImpl;
import peaksoft.dao.InstructorDaoImpl;
import peaksoft.dao.LessonDaoImpl;
import peaksoft.dao.TaskDaoImpl;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        TaskDaoImpl taskDao = new TaskDaoImpl();
        LessonDaoImpl lessonDao = new LessonDaoImpl();
        CourseDaoImpl courseDao = new CourseDaoImpl();
        InstructorDaoImpl instructorDao = new InstructorDaoImpl();

        Task task1 = new Task("ORM",LocalDate.of(2022,10,6),"reade");
        Task task2 = new Task("HQL",LocalDate.of(2022,9,3),"create");
        Task task3 = new Task("OneToOne",LocalDate.of(2022,11,1),"create");

        Lesson lesson1 = new Lesson("Hibernate");
        Lesson lesson2 = new Lesson("Hibernate2");
        Lesson lesson3 = new Lesson("JDBC");

        Course course1 = new Course("Java",9,LocalDate.of(2022,07,1)
                ,"hhtpjava","jkk");
        Course course2 = new Course("JS",9,LocalDate.of(2022,07,1)
                ,"httpjs","jsk");

        Instructor instructor1 = new Instructor("Janara","Kubanychova","@JanarK",999125698);
        Instructor instructor2 = new Instructor("Dastan","Capybaev","@dasss",999159823);




//         courseDao.saveCourse(course1);
//         courseDao.saveCourse(course2);
//        System.out.println(courseDao.getCourseById(1L));
//        System.out.println(courseDao.getAllCourses());
//        courseDao.updateCourse(new Course(),2L);
//         courseDao.deleteCourseById(2L);
//        System.out.println(courseDao.getCourseByName("Java"));

//        lessonDao.saveLessonTable(lesson3,2L);
//         lessonDao.updateLesson(new Lesson(),1L);
//        System.out.println(lessonDao.getLessonById(7L));
//        System.out.println(lessonDao.getLessonsByCourseId(1L));


//        taskDao.saveTaskTable(task2,2L);
//          taskDao.updateTask(new Task(),1L);
//        System.out.println(taskDao.getAllTaskByLessonId(2L));
//        System.out.println(taskDao.deleteTaskById(1L));

//          instructorDao.saveInstructorTable(instructor1);
//          instructorDao.saveInstructorTable(instructor2);
//        instructorDao.updateInstructor(new Instructor(),1L);
//        System.out.println(instructorDao.getInstructorById(2L));
//          instructorDao.deleteInstructorById(2L);

    }

}
