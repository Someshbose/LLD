package someshbose.github.io.domain.repo;

import org.springframework.data.repository.CrudRepository;
import someshbose.github.io.domain.model.User;

public interface UserRepo extends CrudRepository<User,Long> {
}
