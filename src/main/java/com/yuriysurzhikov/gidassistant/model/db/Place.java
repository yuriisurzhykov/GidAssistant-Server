package com.yuriysurzhikov.gidassistant.model.db;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "place")
public class Place {

    @Id
    public String id;
    public String name;
    public String description;
    public String googleUrl;
    public String photoUrl;
    public Double latitude;
    public Double longitude;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "place_interest",
            joinColumns = { @JoinColumn(name = "place_id") },
            inverseJoinColumns = { @JoinColumn(name = "interest_id") }
    )
    public List<Interest> interests = new ArrayList<>();

    @ManyToMany(mappedBy = "places")
    public List<Route> routes = new ArrayList<>();
}
