package es.uniovi.notaineitor.validators;

import es.uniovi.notaineitor.entities.User;
import es.uniovi.notaineitor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SignUpFormValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");
        if (user.getDni().length() < 5 || user.getDni().length() > 24) {
            errors.rejectValue("dni", "Error.signup.dni.length");}

        if (userService.getUserByDni(user.getDni()) != null) {
            errors.rejectValue("dni", "Error.signup.dni.duplicate");}
        if (user.getName().length() < 5 || user.getName().length() > 24) {
            errors.rejectValue("name", "Error.signup.name.length");}
        if (user.getLastname().length() < 5 || user.getLastname().length() > 24) {
            errors.rejectValue("lastname", "Error.signup.lastname.length");}
        if (user.getPassword().length() < 5 || user.getPassword().length() > 24) {
            errors.rejectValue("password", "Error.signup.password.length");}
        if (!user.getRepeatPassword().equals(user.getPassword())) {
            errors.rejectValue("repeatPassword",
                    "Error.signup.repeatPassword.coincidence");}
    }
}
