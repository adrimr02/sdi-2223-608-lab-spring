package es.uniovi.noteneitor.services;

import es.uniovi.noteneitor.entities.Mark;
import es.uniovi.noteneitor.entities.Professor;
import es.uniovi.noteneitor.repositories.ProfessorRepository;
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

    public Professor getProfessor(String dni) {
        return professorRepository.findById(dni).get();
    }

    public void addProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    public void deleteProfessor(String dni) {
        professorRepository.deleteById(dni);
    }
}
