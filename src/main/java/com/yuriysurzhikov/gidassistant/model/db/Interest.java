package com.yuriysurzhikov.gidassistant.model.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "interest")
public class Interest {

    @Id
    public String id;
    public String name;

    @ManyToMany(mappedBy = "interests")
    protected List<User> users = new ArrayList<>();

    @ManyToMany(mappedBy = "interests")
    protected List<Place> places = new ArrayList<>();
}
