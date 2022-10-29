package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@Table(name = "courses1")
@NoArgsConstructor
public class Course {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private int duration;
    private LocalDate createAt;
    private String imageLink;
    private String description;

    @ManyToMany(cascade = ALL,fetch = FetchType.EAGER,mappedBy = "courses")
    List<Instructor>instructors = new ArrayList<>();

    @OneToMany(cascade = {DETACH,MERGE,REFRESH,PERSIST,REMOVE},fetch = FetchType.LAZY,mappedBy = "course")
    private List<Lesson>lessons;


    public Course(String courseName, int duration, LocalDate createAt, String imageLink
            , String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;

    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", createAt=" + createAt +
                ", imageLink='" + imageLink + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
