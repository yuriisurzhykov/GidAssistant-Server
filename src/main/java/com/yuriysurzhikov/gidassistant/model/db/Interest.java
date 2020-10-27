package com.yuriysurzhikov.gidassistant.model.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "interest")
public class Interest {

    @Id
    String id;
    String name;

    @ManyToMany(mappedBy = "interests")
    protected Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "interests")
    protected Set<Place> places = new HashSet<>();
}
