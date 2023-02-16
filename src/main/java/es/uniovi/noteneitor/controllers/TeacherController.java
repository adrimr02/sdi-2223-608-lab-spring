package es.uniovi.noteneitor.controllers;

import es.uniovi.noteneitor.entities.Teacher;
import es.uniovi.noteneitor.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/teachers/list")
    public String getTeachers() {
        return teacherService.getTeachers().toString();
    }

    @RequestMapping(value = "/teachers/add", method = RequestMethod.POST)
    public String addTeachers(@ModelAttribute Teacher teacher) {
        teacherService.addTeacher(teacher);
        return "Ok";
    }

    @RequestMapping("/teachers/details/{dni}")
    public String getTeacher(@PathVariable String dni) {
        return teacherService.getTeacher(dni).toString();
    }

    @RequestMapping( "/teachers/delete/{dni}")
    public String deleteTeachers(@PathVariable String dni) {
        teacherService.deleteTeacher(dni);
        return "Ok";
    }

}
