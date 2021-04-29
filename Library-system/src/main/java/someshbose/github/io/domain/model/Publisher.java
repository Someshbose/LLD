package someshbose.github.io.domain.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "LS_PUBLISHER")
@Getter
@Builder
public class Publisher {

    @Id
    @Column(name = "PUBLISHER_ID")
    private long id;

    private String year_of_publication;

    private String name;


}
