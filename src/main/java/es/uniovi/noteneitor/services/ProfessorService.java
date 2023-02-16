package es.uniovi.noteneitor.services;

import es.uniovi.noteneitor.entities.Professor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {

    List<Professor> professors = new ArrayList<>();

    public List<Professor> getProfessors() {
        return new ArrayList<>(professors);
    }

    public Professor getProfessor(String dni) {
        return professors.stream().filter(p -> p.getDni().equals(dni)).findFirst().get();
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void deleteProfessor(String dni) {
        professors.removeIf(p -> p.getDni().equals(dni));
    }
}
