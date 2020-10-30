package com.yuriysurzhikov.gidassistant.model.db;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "route")
public class Route {

    @Id
    public String id;
    public String name;
    public Integer amountPlaces;
    public Long routeLengthM;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "route_places",
            joinColumns = {@JoinColumn(name = "route_id")},
            inverseJoinColumns = {@JoinColumn(name = "place_id")}
    )
    public List<Place> places = new ArrayList<>();
}
