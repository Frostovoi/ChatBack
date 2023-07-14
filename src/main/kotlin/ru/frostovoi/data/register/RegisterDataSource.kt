package ru.frostovoi.data.register

import ru.frostovoi.data.model.User

interface RegisterDataSource {

    suspend fun createNewUser(user: User) {

    }
}
