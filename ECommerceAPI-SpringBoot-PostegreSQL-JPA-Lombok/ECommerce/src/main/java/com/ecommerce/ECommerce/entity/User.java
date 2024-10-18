package com.ecommerce.ECommerce.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "userss")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class User {


    public User(String name, String surname, String username, String password, String email) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @Column(name = "name")
    private String name;


    @Column(name = "surname")
    private String surname;


    @Column(name = "username")
    private String username;


    @Column(name = "password")
    private String password;


    @Column(name = "email")
    private String email;

}
