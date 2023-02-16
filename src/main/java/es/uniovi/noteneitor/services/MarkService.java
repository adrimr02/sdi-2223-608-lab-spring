package es.uniovi.noteneitor.services;

import es.uniovi.noteneitor.entities.Mark;
import es.uniovi.noteneitor.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkService {

    @Autowired
    private MarkRepository marksRepository;

    public List<Mark> getMarks() {
        List<Mark> marks = new ArrayList<>();
        marksRepository.findAll().forEach(marks::add);
        return marks;
    }
    public Mark getMark(Long id) {
        return marksRepository.findById(id).get();
    }
    public void addMark(Mark mark) {
       marksRepository.save(mark);
    }
    public void deleteMark(Long id) {
        marksRepository.deleteById(id);
    }

}
