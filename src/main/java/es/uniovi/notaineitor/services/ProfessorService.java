package es.uniovi.notaineitor.services;

import es.uniovi.notaineitor.entities.Professor;
import es.uniovi.notaineitor.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> getProfessors() {
        List<Professor> professors = new ArrayList<>();
        professorRepository.findAll().forEach(professors::add);
        return professors;
    }

    public Page<Professor> getPagedProfessors(Pageable pageable) {
        return professorRepository.getPagedProfessors(pageable);
    }

    public Professor getProfessor(long id) {
        var result = professorRepository.findById(id);
        return result.orElse(null);
    }
    public Professor getProfessorByDni(String dni) {
        return professorRepository.findByDni(dni);
    }

    public void addProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    public void deleteProfessor(long id) {
        professorRepository.deleteById(id);
    }
}
