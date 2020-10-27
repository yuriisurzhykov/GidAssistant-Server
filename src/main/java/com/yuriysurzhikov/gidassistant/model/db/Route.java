package com.yuriysurzhikov.gidassistant.model.db;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "route")
public class Route {

    @Id
    String id;
    String name;
    Integer amountPlaces;
    Long routeLengthM;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "route_places",
            joinColumns = {@JoinColumn(name = "route_id")},
            inverseJoinColumns = {@JoinColumn(name = "place_id")}
    )
    Set<Place> places = new HashSet<>();
}
