package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private LocalDate deadLine;
    private String task;
    @ManyToOne(cascade = {DETACH,REFRESH,MERGE},fetch = FetchType.EAGER)
    @JoinColumn(name = "lesson_id",referencedColumnName = "id")
    private Lesson lesson;



    public Task(String name, LocalDate deadLine, String task) {
        this.name = name;
        this.deadLine = deadLine;
        this.task = task;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deadLine=" + deadLine +
                ", task='" + task + '\'' +
                '}';
    }
}
