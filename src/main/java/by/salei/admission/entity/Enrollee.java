package by.salei.admission.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "enrollee")
@Data
public class Enrollee extends AbstractEntity {

    private String firstName;
    private String lastName;

    @OneToOne
    @JoinColumn(name = "certificate_id", unique = true)
    private Certificate certificate;

    @OneToMany(mappedBy = "enrollee")
    private List<EnrolleeSubject> enrolleeSubjects;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToOne(mappedBy = "enrollee")
    private Student student;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
