package someshbose.github.io.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "LS_PUBLISHER")
public class Publisher {

    @Id
    @Column(name = "PUBLISHER_ID")
    private long id;

    private Date year_of_publication;

    private String name;


}
