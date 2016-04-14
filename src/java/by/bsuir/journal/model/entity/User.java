package by.bsuir.journal.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Veronika
 */

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "Id")
    private int id;

    @Column(name = "Login")
    private String login;

    @Column(length = 50,name = "PasswordHash")
    private String passwordHash;

    @Column(name = "Email",length = 50, columnDefinition = "nvarchar")
    private String email;

    @Column(name = "Name",length = 50, columnDefinition = "nvarchar")
    private String name;

    @Column(name = "Surname",length = 40, columnDefinition = "nvarchar")
    private String surname;

    @Column(name = "Role",length = 20, columnDefinition = "nvarchar")
    private Role role;

    public enum Role {
        EMPLOYEE, USER, MANAGER, BLOCKED
    }

    public User() {}
    public User(int id, String login){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", passwordHash=" + passwordHash +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role=" + role +
                '}';
    }
}
