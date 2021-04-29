package someshbose.github.io.domain.model;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "TEST_USER")
@Builder
public class User {

    @Id
    @Column(name = "id")
    private long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
