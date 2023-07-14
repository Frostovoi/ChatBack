package ru.frostovoi.data.login

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

import java.util.*

fun Route.loginRoute(login: LoginDataSource) {

    post("/login"){
        val receivedLogin = call.receive(LoginReceiveRemote::class)
        val user = login.findUser(receivedLogin.login, receivedLogin.password)
        user?.token.let { token ->
            if (token == receivedLogin.token) {
                call.respond(HttpStatusCode.OK)
                return@post
            }
        }
        user?.let {
            val token = UUID.randomUUID().toString()
            login.updateToken(user.username, token)
            call.respond(LoginResponseRemote(token = token))
        } ?: call.respond(HttpStatusCode.BadRequest)
    }
}