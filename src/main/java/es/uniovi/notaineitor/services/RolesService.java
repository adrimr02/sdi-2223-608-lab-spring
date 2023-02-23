package es.uniovi.notaineitor.services;

import org.springframework.stereotype.Service;

@Service
public class RolesService {

    private final String[] roles = {"ROLE_STUDENT", "ROLE_PROFESSOR", "ROLE_ADMIN"};

    public String[] getRoles() {
        return this.roles;
    }

}
