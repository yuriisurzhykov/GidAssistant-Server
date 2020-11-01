package com.yuriysurzhikov.gidassistant.model.db;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "interest")
public class Interest {

    @Id
    @Column(name = "name", unique = true)
    public String name;

    @ManyToMany(mappedBy = "interests")
    protected List<User> users = new ArrayList<>();

    @ManyToMany(mappedBy = "interests")
    protected List<Place> places = new ArrayList<>();
}
