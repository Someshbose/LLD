package someshbose.github.io.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LS_BOOK")
public class Book {

    @Id
    @Column(name = "ISBN")
    private long id;

    private String author_name;

    private Publisher publisher;

    private String title;

    private long edition;

    private String category;

    private double price;
}
