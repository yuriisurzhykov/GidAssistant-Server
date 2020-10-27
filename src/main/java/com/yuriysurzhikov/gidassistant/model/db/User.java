package com.yuriysurzhikov.gidassistant.model.db;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {

    @Id
    String id;
    String name;
    String passwd;
    Long birthday;
    Integer age;
    @ManyToOne
    @JoinColumn(name="city_id", nullable=false)
    City city;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_interest",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "interest_id") }
    )
    Set<Interest> interests = new HashSet<>();
}
