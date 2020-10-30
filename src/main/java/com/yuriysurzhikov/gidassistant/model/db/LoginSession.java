package com.yuriysurzhikov.gidassistant.model.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "session")
public class LoginSession {

    @Id
    public String id;
}
