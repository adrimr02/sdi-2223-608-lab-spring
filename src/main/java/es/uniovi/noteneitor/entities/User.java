package es.uniovi.noteneitor.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique=true)
    private String dni;
    private String name;
    private String lastname;

    private String password;

    @Transient
    private String repeatPassword;

    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Mark> marks;

    public User() {}

    public User(String dni, String name, String lastname) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.marks = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Mark> getMarks() {
        return new HashSet<>( marks );
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getFullName() {
        return name + " " + lastname;
    }
}
