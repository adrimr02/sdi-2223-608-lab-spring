package es.uniovi.noteneitor.controllers;

import es.uniovi.noteneitor.entities.Professor;
import es.uniovi.noteneitor.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @RequestMapping("/professor/list")
    public String getProfessors(Model model) {
        model.addAttribute("professorList", professorService.getProfessors());
        return "professor/list";
    }

    @RequestMapping("professor/add")
    public String addProfessorView() {
        return "professor/add";
    }

    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String addProfessor(@ModelAttribute Professor professor) {
        professorService.addProfessor(professor);
        return "redirect:/professor/list";
    }

    @RequestMapping("/professor/details/{dni}")
    public String getProfessor(Model model, @PathVariable String dni) {
        model.addAttribute("professor", professorService.getProfessor(dni));
        return "professor/details";
    }

    @RequestMapping( "/professor/delete/{dni}")
    public String deleteProfessor(@PathVariable String dni) {
        professorService.deleteProfessor(dni);
        return "redirect:/professor/list";
    }

    @RequestMapping("professor/edit/{dni}")
    public String updateProfessorView(Model model, @PathVariable String dni) {
        model.addAttribute("professor", professorService.getProfessor(dni));
        return "professor/edit";
    }

    @RequestMapping(value = "/professor/edit", method = RequestMethod.POST)
    public String updateProfessor(@ModelAttribute Professor professor) {
        professorService.addProfessor(professor);
        return "redirect:/professor/list";
    }

}
