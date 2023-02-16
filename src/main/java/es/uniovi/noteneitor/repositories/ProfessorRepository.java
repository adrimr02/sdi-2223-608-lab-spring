package es.uniovi.noteneitor.repositories;

import es.uniovi.noteneitor.entities.Mark;
import es.uniovi.noteneitor.entities.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, String> {
}
