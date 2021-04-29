package someshbose.github.io.domain.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import someshbose.github.io.domain.model.Address;

import java.nio.file.LinkOption;

@Repository
public interface AddressRepo extends CrudRepository<Address,Long> {

}
