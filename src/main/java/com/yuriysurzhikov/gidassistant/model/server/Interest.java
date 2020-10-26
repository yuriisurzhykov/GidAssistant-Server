package com.yuriysurzhikov.gidassistant.model.server;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Interest {

    private String id;
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
