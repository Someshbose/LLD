package someshbose.github.io.domain.model;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "TEST_ADDRESS")
@Builder
public class Address {

    @Id
    @Column(name = "id")
    private long id;

    @OneToOne(mappedBy = "address")
    private User user;
}
