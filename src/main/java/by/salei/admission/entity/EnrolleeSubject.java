package by.salei.admission.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "subject")
@Data
public class EnrolleeSubject extends AbstractEntity{

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "subject_type_id")
    private Subject subject_type;

    @ManyToOne
    @JoinColumn(name = "enrollee_id")
    private Enrollee enrollee;
}
