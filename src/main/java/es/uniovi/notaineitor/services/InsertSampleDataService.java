package es.uniovi.notaineitor.services;

import es.uniovi.notaineitor.entities.Mark;
import es.uniovi.notaineitor.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class InsertSampleDataService {

    @Autowired
    private UserService userService;

    @Autowired
    private RolesService rolesService;

    //@PostConstruct
    public void init() {
        User user1 = new User("99999990A", "Pedro", "Díaz");
        user1.setPassword("123456");
        user1.setRole(rolesService.getRoles()[0]);
        User user2 = new User("99999991B", "Lucas", "Núñez");
        user2.setPassword("123456");
        user2.setRole(rolesService.getRoles()[0]);
        User user3 = new User("99999992C", "María", "Rodríguez");
        user3.setPassword("123456");
        user3.setRole(rolesService.getRoles()[0]);
        User user4 = new User("99999993D", "Marta", "Almonte");
        user4.setPassword("123456");
        user4.setRole(rolesService.getRoles()[1]);
        User user5 = new User("99999977E", "Pelayo", "Valdes");
        user5.setPassword("123456");
        user5.setRole(rolesService.getRoles()[1]);
        User user6 = new User("99999988F", "Edward", "Núñez");
        user6.setPassword("123456");
        user6.setRole(rolesService.getRoles()[2]);

        Set<Mark> user1Marks = new HashSet<>() {
            {
                add(new Mark("Nota A1", 10.0, user1));
                add(new Mark("Nota A2", 9.0, user1));
                add(new Mark("Nota A3", 7.0, user1));
                add(new Mark("Nota A4", 6.5, user1));
            }
        };
        user1.setMarks(user1Marks);

        Set<Mark> user2Marks = new HashSet<>() {
            {
                add(new Mark("Nota B1", 5.0, user2));
                add(new Mark("Nota B2", 4.3, user2));
                add(new Mark("Nota B3", 8.0, user2));
                add(new Mark("Nota B4", 3.5, user2));
            }
        };
        user2.setMarks(user2Marks);
        Set<Mark> user3Marks = new HashSet<>() {
            {
                add(new Mark("Nota C1", 5.5, user3));
                add(new Mark("Nota C2", 6.6, user3));
                add(new Mark("Nota C3", 7.0, user3));
            }
        };
        user3.setMarks(user3Marks);

        Set<Mark> user4Marks = new HashSet<>() {
            {
                add(new Mark("Nota D1", 10.0, user4));
                add(new Mark("Nota D2", 8.0, user4));
                add(new Mark("Nota D3", 9.0, user4));
            }
        };
        user4.setMarks(user4Marks);

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);
        userService.addUser(user5);
        userService.addUser(user6);
    }

}
