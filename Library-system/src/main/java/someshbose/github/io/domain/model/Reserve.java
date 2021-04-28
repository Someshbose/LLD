package someshbose.github.io.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "LS_RESERVE")
public class Reserve {

    @Id
    @Column(name = "RESERVATION_ID")
    private long id;

    private Book book;

    private Reader reader;

    private Date reserveDate;

    private Date dueDate;

    private Date returnDate;
}
