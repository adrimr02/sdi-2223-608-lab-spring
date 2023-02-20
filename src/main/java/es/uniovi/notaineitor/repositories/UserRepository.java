package es.uniovi.notaineitor.repositories;

import es.uniovi.notaineitor.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByDni(String dni);

}
