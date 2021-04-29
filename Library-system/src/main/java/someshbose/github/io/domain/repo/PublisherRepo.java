package someshbose.github.io.domain.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import someshbose.github.io.domain.model.Publisher;

import java.util.List;

@Repository
public interface PublisherRepo extends CrudRepository<Publisher,Long> {

    Publisher findById(long id);
}
