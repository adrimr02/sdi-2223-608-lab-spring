package es.uniovi.notaineitor.validators;

import es.uniovi.notaineitor.entities.Professor;
import es.uniovi.notaineitor.entities.User;
import es.uniovi.notaineitor.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProfessorFormValidator implements Validator {

    @Autowired
    private ProfessorService professorService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Professor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Professor professor = (Professor) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");
        if (professor.getDni().length() != 9) {
            errors.rejectValue("dni", "Error.signup.dni.length");}

        if (professorService.getProfessorByDni(professor.getDni()) != null) {
            errors.rejectValue("dni", "Error.signup.dni.duplicate");}
        if (professor.getName().length() < 5 || professor.getName().length() > 24) {
            errors.rejectValue("name", "Error.signup.name.length");}
        if (professor.getLastname().length() < 5 || professor.getLastname().length() > 24) {
            errors.rejectValue("lastname", "Error.signup.lastname.length");}
    }
}
