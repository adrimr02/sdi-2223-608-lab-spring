package es.uniovi.notaineitor.repositories;

import es.uniovi.notaineitor.entities.Mark;
import es.uniovi.notaineitor.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MarkRepository extends CrudRepository<Mark, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Mark SET resend = ?1 WHERE id = ?2")
    void updateResend(Boolean resend, Long id);

    @Query("SELECT r FROM Mark r WHERE r.user = ?1 ORDER BY r.id ASC")
    List<Mark> findAllByUser(User user);

    @Query("SELECT r FROM Mark r WHERE (lower(r.description) LIKE lower(?1) OR lower(r.user.name) LIKE lower(?1))")
    List<Mark> searchByDescriptionAndName(String query);

    @Query("SELECT r FROM Mark r WHERE (lower(r.description) LIKE lower(?1) OR lower(r.user.name) LIKE lower(?1)) AND r.user = ?2")
    List<Mark> searchByDescriptionNameAndUser(String query, User user);

}
