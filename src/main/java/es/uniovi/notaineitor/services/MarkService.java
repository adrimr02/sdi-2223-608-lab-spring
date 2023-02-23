package es.uniovi.notaineitor.services;

import es.uniovi.notaineitor.entities.Mark;
import es.uniovi.notaineitor.entities.User;
import es.uniovi.notaineitor.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MarkService {

    @Autowired
    private MarkRepository marksRepository;

    public Page<Mark> getMarks(Pageable pageable) {
        return marksRepository.findAll(pageable);
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

    public void setMarkResend(boolean revised, Long id) {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        String dni = auth.getName();
        Mark mark = marksRepository.findById(id).get();

        if (mark.getUser().getDni().equals(dni))
            marksRepository.updateResend(revised, id);

    }

    public Page<Mark> getMarksForUser(Pageable pageable, User user) {
        Page<Mark> marks = new PageImpl<>(new LinkedList<>());
        if (user.getRole().equals("ROLE_STUDENT"))
            marks = marksRepository.findAllByUser(pageable, user);

        if (user.getRole().equals("ROLE_PROFESSOR"))
            marks = getMarks(pageable);

        return marks;
    }

    public Page<Mark> searchMarksByDescriptionAndNameForUser(Pageable pageable, String query, User user) {
        Page<Mark> marks = new PageImpl<>(new LinkedList<>());
        query = "%"+query+"%";
        if (user.getRole().equals("ROLE_STUDENT"))
            marks = marksRepository.searchByDescriptionNameAndUser(pageable, query, user);

        if (user.getRole().equals("ROLE_PROFESSOR"))
            marks = marksRepository.searchByDescriptionAndName(pageable, query);

        return marks;
    }

}
