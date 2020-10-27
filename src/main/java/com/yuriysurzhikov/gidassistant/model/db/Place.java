package com.yuriysurzhikov.gidassistant.model.db;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "place")
public class Place {

    @Id
    String id;
    String name;
    String description;
    String googleUrl;
    String photoUrl;
    Double latitude;
    Double longitude;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "place_interest",
            joinColumns = { @JoinColumn(name = "place_id") },
            inverseJoinColumns = { @JoinColumn(name = "interest_id") }
    )
    Set<Interest> interests = new HashSet<>();

    @ManyToMany(mappedBy = "places")
    protected Set<Route> routes = new HashSet<>();
}
