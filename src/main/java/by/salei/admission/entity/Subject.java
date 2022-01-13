package by.salei.admission.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "subject_type")
@Data
public class Subject extends AbstractEntity{

    @Enumerated(EnumType.STRING)
    private SubjectType type;

    @OneToMany(mappedBy = "subject_type")
    private List<EnrolleeSubject> subjects;

    @ManyToMany(mappedBy = "subjects")
    private List<Faculty> faculties;
}
