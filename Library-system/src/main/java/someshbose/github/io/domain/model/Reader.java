package someshbose.github.io.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LS_READER")
public class Reader {

    @Id
    @Column(name = "READER_ID")
    private long id;

    private String email;

    private String address;

    private long contact;

    private String firstName;

    private String lastName;


}
