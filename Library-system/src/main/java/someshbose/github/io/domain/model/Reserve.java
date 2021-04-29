package someshbose.github.io.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LS_RESERVE")
public class Reserve {

    @Id
    @Column(name = "RESERVATION_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "ISBN",nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "READER_ID",nullable = false)
    private Reader reader;

    private Date reserveDate;

    private Date dueDate;

    private Date returnDate;
}
