package es.uniovi.notaineitor.controllers;

import es.uniovi.notaineitor.entities.Mark;
import es.uniovi.notaineitor.services.MarkService;
import es.uniovi.notaineitor.services.UserService;
import es.uniovi.notaineitor.validators.MarkFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Controller
public class MarkController {

    @Autowired
    private MarkService marksService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private MarkFormValidator markFormValidator;

    @RequestMapping("/mark/list")
    public String getList(Model model) {
        Set<Mark> consultedList = (Set<Mark>) httpSession.getAttribute("consultedList");
        if (consultedList == null)
            consultedList = new HashSet<>();

        model.addAttribute("consultedList", consultedList);
        model.addAttribute("markList", marksService.getMarks());
        return "mark/list";
    }

    @RequestMapping("/mark/add")
    public String getMark(Model model) {
        model.addAttribute("userList", userService.getUsers());
        model.addAttribute("mark", new Mark());
        return "mark/add";
    }

    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    public String setMark(@Validated Mark mark, BindingResult result, Model model) {
        markFormValidator.validate(mark, result);
        if (result.hasErrors()) {
            model.addAttribute("userList", userService.getUsers());
            model.addAttribute("mark", mark);
            return "mark/add";
        }

        marksService.addMark(mark);
        return "redirect:/mark/list";
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
        marksService.deleteMark(id);
        return "redirect:/mark/list";
    }
    @RequestMapping("/mark/details/{id}")
    public String getDetail(Model model, @PathVariable long id) {
        model.addAttribute("mark", marksService.getMark(id));
        return "mark/details";

    }

    @RequestMapping(value = "/mark/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        return "mark/edit";
    }

    @RequestMapping(value="/mark/edit/{id}", method=RequestMethod.POST)
    public String setEdit(@Validated Mark mark, @PathVariable Long id, BindingResult result, Model model){
        markFormValidator.validate(mark, result);
        if (result.hasErrors()) {
            model.addAttribute("mark", mark);
            return "mark/edit";
        }

        Mark originalMark = marksService.getMark(id);
        originalMark.setScore(mark.getScore());
        originalMark.setDescription(mark.getDescription());
        marksService.addMark(originalMark);
        return "redirect:/mark/details/"+id;
    }


    @RequestMapping("/mark/list/update")
    public String updateList(Model model) {
        model.addAttribute("markList", marksService.getMarks());
        return "mark/list::tableMarks";
    }

}
