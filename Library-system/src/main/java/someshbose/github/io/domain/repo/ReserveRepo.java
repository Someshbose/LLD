package someshbose.github.io.domain.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import someshbose.github.io.domain.model.Reserve;

@Repository
public interface ReserveRepo extends CrudRepository<Reserve,Long> {
}
