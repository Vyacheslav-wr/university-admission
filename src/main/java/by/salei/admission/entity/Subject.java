package by.salei.admission.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "subject_type")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject extends AbstractEntity{

    @Enumerated(EnumType.STRING)
    private SubjectType type;

    @OneToMany(mappedBy = "subject_type")
    private List<EnrolleeSubject> subjects;

    @ManyToMany(mappedBy = "subjects")
    private List<Faculty> faculties;
}
