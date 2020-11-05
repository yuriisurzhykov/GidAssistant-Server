package com.yuriysurzhikov.gidassistant.auth

import com.yuriysurzhikov.gidassistant.model.db.LoginSession
import com.yuriysurzhikov.gidassistant.model.login.SessionData
import java.util.*

object LoginSessionCreator {

    @JvmStatic
    fun createSession(user: SessionData?): LoginSession {
        val session = LoginSession()
        session.id = UUID.randomUUID().toString()
        session.macAddr = user?.macAddr
        session.sessionIP = user?.clientIP
        session.sessionTime = Calendar.getInstance().time.time
        return session
    }
}