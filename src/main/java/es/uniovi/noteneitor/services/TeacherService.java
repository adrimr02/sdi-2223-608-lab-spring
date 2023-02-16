package es.uniovi.noteneitor.services;

import es.uniovi.noteneitor.entities.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    List<Teacher> teachers = new ArrayList<>();

    public List<Teacher> getTeachers() {
        return new ArrayList<>( teachers );
    }

    public Teacher getTeacher(String dni) {
        return teachers.stream().filter(t -> t.getDni().equals(dni)).findFirst().get();
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void deleteTeacher(String dni) {
        teachers.removeIf(t -> t.getDni().equals(dni));
    }
}
