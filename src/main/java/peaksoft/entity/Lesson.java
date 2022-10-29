package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(cascade = {DETACH,MERGE,REFRESH},fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    private Course course;

//    @OneToMany(cascade = ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name = "lesson_id",referencedColumnName = "id")
//    private List<Task> tasks;

    public Lesson(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
