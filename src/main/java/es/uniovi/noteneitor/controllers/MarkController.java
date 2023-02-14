package es.uniovi.noteneitor.controllers;

import es.uniovi.noteneitor.entities.Mark;
import es.uniovi.noteneitor.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarkController {

    @Autowired
    private MarksService marksService;

    @RequestMapping("/mark/list")
    public String getList() {
        return marksService.getMarks().toString();
    }

    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    public String setMark(@ModelAttribute Mark mark) {
        marksService.addMark(mark);
        return "Ok";
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
        marksService.deleteMark(id);
        return "Ok";
    }
    @RequestMapping("/mark/details/{id}")
    public String getDetail(@PathVariable long id) {
        return marksService.getMark(id).toString();
    }


}
