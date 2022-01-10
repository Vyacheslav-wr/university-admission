package by.salei.admission.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "certificate")
@Data
public class Certificate extends AbstractEntity{

    private Double score;

    @OneToOne(mappedBy = "certificate")
    private Enrollee enrollee;
}
