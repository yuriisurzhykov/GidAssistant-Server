package com.yuriysurzhikov.gidassistant.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {

    @Id
    public String id;
    public String name;
    public String email;
    public String login;
    public String passwd;
    public Long birthday;
    public Integer age;
    @ManyToOne
    @JoinColumn(name="city_id", nullable=false)
    public City city;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable (
            name = "user_interest",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "interest_name") }
    )
    public List<Interest> interests = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    public List<LoginSession> loginSessions = new ArrayList<>();
}
