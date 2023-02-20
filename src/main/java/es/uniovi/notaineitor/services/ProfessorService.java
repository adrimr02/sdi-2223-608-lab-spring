package es.uniovi.notaineitor.services;

import es.uniovi.notaineitor.entities.Professor;
import es.uniovi.notaineitor.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Professor getProfessor(long id) {
        return professorRepository.findById(id).get();
    }

    public void addProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    public void deleteProfessor(long id) {
        professorRepository.deleteById(id);
    }
}
