package ru.frostovoi.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import org.koin.ktor.ext.inject
import ru.frostovoi.data.login.LoginDataSource
import ru.frostovoi.data.login.loginRoute
import ru.frostovoi.data.register.RegisterDataSource
import ru.frostovoi.data.register.registerRoute
import ru.frostovoi.room.RoomController
import ru.frostovoi.routes.chatSocket
import ru.frostovoi.routes.getAllMessages

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    val login by inject<LoginDataSource>()
    val register by inject<RegisterDataSource>()
    install(Routing) {
        chatSocket(roomController)
        getAllMessages(roomController)
        loginRoute(login)
        registerRoute(register)
    }

}
