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

    List<Mark> findAllByUser(User user);

}
