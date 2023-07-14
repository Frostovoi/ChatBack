package ru.frostovoi.data.register

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.frostovoi.data.model.User
import java.util.*


fun Route.registerRoute(registerSource: RegisterDataSource) {
    post("/register"){
        val register = call.receive(RegisterReceiveRemote::class)
        val token = UUID.randomUUID().toString()
        val user = User(
            username = register.login,
            password = register.password,
            token = token,
        )
        registerSource.createNewUser(user = user)

        call.respond(RegisterResponseRemote(token = token))
        return@post
    }
}