package someshbose.github.io.domain.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import someshbose.github.io.domain.model.Book;

@Repository
public interface BookRepo extends CrudRepository<Book,Long> {
}
