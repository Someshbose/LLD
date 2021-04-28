package someshbose.github.io.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LS_STAFF")
public class Staff {

    @Id
    @Column(name = "STAFF_ID")
    private long id;

    private String staffName;
}
