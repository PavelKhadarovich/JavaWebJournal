package by.bsuir.journal.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Veronika.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;
    @Column(name = "email")
    private String email;
    @Column(name = "encrypted_password")
    private byte[] encryptedPassword;
    @Column(name = "password_salt")
    private byte[] passwordSalt;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "about")
    private String about;

    public User(String email, byte[] encryptedPassword, byte[] passwordSalt,
                String name, String surname, UserType userType) {
        this.userType = userType;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
        this.passwordSalt = passwordSalt;
        this.name = name;
        this.surname = surname;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(byte[] encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public byte[] getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(byte[] passwordSalt) {
        this.passwordSalt = passwordSalt;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
