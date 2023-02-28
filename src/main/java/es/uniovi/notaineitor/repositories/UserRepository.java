package es.uniovi.notaineitor.repositories;

import es.uniovi.notaineitor.entities.Mark;
import es.uniovi.notaineitor.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByDni(String dni);


    @Query("SELECT r FROM User r ORDER BY r.id ASC")
    Page<User> getPagedUsers(Pageable pageable);
    @Query("SELECT u FROM User u WHERE (lower(u.name) LIKE lower(?1) OR lower(u.lastname) LIKE lower(?1))")
    Page<User> searchByNameAndSurname(Pageable pageable, String query);

}
