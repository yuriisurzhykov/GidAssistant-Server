package com.yuriysurzhikov.gidassistant.model.login

data class SessionData(
        var sessionId: String,
        var sessionTime: Long,
        var clientIP: String,
        var macAddr: String
) {
    constructor(): this("", 0L, "", "")
}