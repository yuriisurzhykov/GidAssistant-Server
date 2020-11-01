package com.yuriysurzhikov.gidassistant.auth;

import com.yuriysurzhikov.gidassistant.model.db.LoginSession;
import com.yuriysurzhikov.gidassistant.model.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<LoginSession, String> {
    LoginSession findSessionBySessionIPAndMacAddr(String ip, String mac);
    List<LoginSession> findSessionsByUser(User user);
}
