package com.yuriysurzhikov.gidassistant.auth

import com.yuriysurzhikov.gidassistant.model.client.UserFromClient
import com.yuriysurzhikov.gidassistant.model.db.LoginSession
import com.yuriysurzhikov.gidassistant.model.login.SessionData
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

object LoginSessionCreator {

    @JvmStatic
    fun createSession(user: SessionData): LoginSession {
        val session = LoginSession()
        session.id = UUID.randomUUID().toString()
        session.sessionIP = user.clientIP
        session.sessionTime = Calendar.getInstance().time.time
        return session
    }
}