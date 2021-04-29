package someshbose.github.io.domain.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "LS_BOOK")
@Getter
@Builder
public class Book {

    @Id
    @Column(name = "ISBN")
    private long id;

    private String author_name;

    @ManyToOne
    @JoinColumn(name = "PUBLISHER_ID",nullable = false)
    private Publisher publisher;

    private String title;

    private long edition;

    private String category;

    private double price;
}
