package com.yuriysurzhikov.gidassistant.model.db;

import javax.persistence.*;

@Entity
@Table(name = "session")
public class LoginSession {

    @Id
    public String id;
    public String sessionIP;
    public Long sessionTime;
    public String macAddr;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    public User user;
}
