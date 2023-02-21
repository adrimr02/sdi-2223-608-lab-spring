package es.uniovi.notaineitor.repositories;

import es.uniovi.notaineitor.entities.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {

    Professor findByDni(String dni);

}
