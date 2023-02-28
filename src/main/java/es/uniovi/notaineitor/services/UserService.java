package es.uniovi.notaineitor.services;

import es.uniovi.notaineitor.entities.User;
import es.uniovi.notaineitor.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }

    public Page<User> getPagedUsers(Pageable pageable) {
        return usersRepository.getPagedUsers(pageable);
    }

    public Page<User> getUsersByNameAndSurname(Pageable pageable, String query) {
        query = "%"+query+"%";
        return usersRepository.searchByNameAndSurname(pageable, query);
    }

    public User getUser(Long id) {
        return usersRepository.findById(id).get();
    }
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    public User getUserByDni(String dni) {
        return usersRepository.findByDni(dni);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    public void updateUser(User user) {
        usersRepository.save(user);
    }


}
