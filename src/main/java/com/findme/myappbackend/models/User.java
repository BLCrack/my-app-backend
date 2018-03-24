package com.findme.myappbackend.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    public User(String login, String password)
    {
        this.login=login;
        this.password=password;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getId()
    {
        return id;
    }

    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }

}
