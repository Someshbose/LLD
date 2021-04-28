package someshbose.github.io.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LS_REPORT")
public class Report {

    @Id
    @Column(name = "REGISTRATION_ID")
    private long id;

    
}
