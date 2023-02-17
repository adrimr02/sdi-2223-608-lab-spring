package es.uniovi.noteneitor.repositories;

import es.uniovi.noteneitor.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
