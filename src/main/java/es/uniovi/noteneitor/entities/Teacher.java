package es.uniovi.noteneitor.entities;

public class Teacher {

    private String dni;

    private String name;

    private String lastname;

    private String category;

    public Teacher() {}

    public Teacher(String dni, String name, String lastname, String category) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
