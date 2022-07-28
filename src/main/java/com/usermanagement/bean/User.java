package com.usermanagement.bean;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    protected int id;

    @Column(name="name")
    protected String name;

    @Column(name="email")
    protected String email;

    @Column(name="university")
    protected String university;

    public User() {
    }

//	Constructor without id parameters

    public User(String name, String email, String university) {
        super();
        this.name = name;
        this.email = email;
        this.university = university;
    }


    //	Constructor with all parameters
    public User(int id, String name, String email, String university) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.university = university;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUniversity() {
        return university;
    }
    public void setUniversity(String country) {
        this.university = country;
    }
}

