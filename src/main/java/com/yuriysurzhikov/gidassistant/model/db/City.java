package com.yuriysurzhikov.gidassistant.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "city")
public class City {

    @Id
    String id;
    String name;
    Double latitude;
    Double longitude;
    String googleUrl;

    @OneToMany(mappedBy="city")
    @JsonIgnore
    protected Set<User> users = new HashSet<>();

}
