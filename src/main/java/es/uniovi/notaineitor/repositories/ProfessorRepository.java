package es.uniovi.notaineitor.repositories;

import es.uniovi.notaineitor.entities.Professor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {

    Professor findByDni(String dni);

    @Query("SELECT r FROM Professor r ORDER BY r.id ASC")
    Page<Professor> getPagedProfessors(Pageable pageable);

}
