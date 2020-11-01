package com.yuriysurzhikov.gidassistant.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "city")
public class City {

    @Id
    public String id;
    public String name;
    public Double latitude;
    public Double longitude;
    public String googleUrl;
    public String photoUrl;
    public String type;

    @OneToMany(mappedBy="city")
    @JsonIgnore
    public List<User> users = new ArrayList<>();

}
