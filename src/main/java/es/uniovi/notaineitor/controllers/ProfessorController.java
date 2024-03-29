package es.uniovi.notaineitor.controllers;

import es.uniovi.notaineitor.entities.Professor;
import es.uniovi.notaineitor.services.ProfessorService;
import es.uniovi.notaineitor.validators.ProfessorFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private ProfessorFormValidator professorFormValidator;

    @RequestMapping("/professor/list")
    public String getProfessors(Model model, Pageable pageable) {
        var professors = professorService.getPagedProfessors(pageable);
        model.addAttribute("professorList", professors.getContent());
        model.addAttribute("page", professors);
        return "professor/list";
    }

    @RequestMapping("professor/add")
    public String addProfessorView(Model model) {
        model.addAttribute("professor", new Professor());
        return "professor/add";
    }

    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String addProfessor(@Validated Professor professor, BindingResult result, Model model) {
        professorFormValidator.validate(professor, result);
        if (result.hasErrors()) {
            model.addAttribute(professor);
            return "professor/add";
        }
        professorService.addProfessor(professor);
        return "redirect:/professor/list";
    }

    @RequestMapping("/professor/details/{id}")
    public String getProfessor(Model model, @PathVariable long id) {
        model.addAttribute("professor", professorService.getProfessor(id));
        return "professor/details";
    }

    @RequestMapping( "/professor/delete/{id}")
    public String deleteProfessor(@PathVariable long id) {
        professorService.deleteProfessor(id);
        return "redirect:/professor/list";
    }

    @RequestMapping("professor/edit/{id}")
    public String updateProfessorView(Model model, @PathVariable long id) {
        model.addAttribute("professor", professorService.getProfessor(id));
        return "professor/edit";
    }

    @RequestMapping(value = "/professor/edit", method = RequestMethod.POST)
    public String updateProfessor(@ModelAttribute Professor professor) {
        professorService.addProfessor(professor);
        return "redirect:/professor/list";
    }

}
