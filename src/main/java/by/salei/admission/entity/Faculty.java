package by.salei.admission.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "faculty")
@Data
public class Faculty extends AbstractEntity{

    private String name;
    private Integer studentsSpots;

    @OneToMany(mappedBy = "faculty")
    private List<Enrollee> enrollees;

    @ManyToMany
    @JoinTable(
            name = "subject_to_faculty",
            joinColumns = @JoinColumn(name = "faculty_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;
}
