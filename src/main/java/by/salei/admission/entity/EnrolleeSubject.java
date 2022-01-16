package by.salei.admission.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "subject")
@Data
@Builder
public class EnrolleeSubject extends AbstractEntity{

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "subject_type")
    private Subject subject_type;

    @ManyToOne
    @JoinColumn(name = "enrollee_id")
    private Enrollee enrollee;
}
