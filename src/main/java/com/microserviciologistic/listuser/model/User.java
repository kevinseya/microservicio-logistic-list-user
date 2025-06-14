package com.microserviciologistic.listuser.model;

import com.microserviciologistic.listuser.service.UUIDConverter;
import jakarta.persistence.*;
import java.util.UUID;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)", unique = true, nullable = false)
    @Convert(converter = UUIDConverter.class)  // Agrega el conversor aquí
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private Boolean active = true;



    public UUID getId() {
        return id;  // Change from Long to UUID
    }

    public void setId(UUID id) {
        this.id = id;
    }

    // Getter y Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter y Setter for lastname
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // Getter y Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter y Setter for phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter y Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter y Setter for rol
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //Getter y Setter for active
    public Boolean getActive() { return active; }

    public void setActive(Boolean active) { this.active = active; }
}
