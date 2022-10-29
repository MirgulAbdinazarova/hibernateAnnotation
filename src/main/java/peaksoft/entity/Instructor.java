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
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    @ManyToMany(cascade = {DETACH,MERGE,REFRESH},fetch = FetchType.LAZY)
    @JoinTable(name = "instructor_courses1",
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Course>courses = new ArrayList<>();

    public Instructor(String firstName, String lastName, String email, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
