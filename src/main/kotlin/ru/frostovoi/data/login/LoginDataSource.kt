package ru.frostovoi.data.login

import ru.frostovoi.data.model.User


interface LoginDataSource {

    suspend fun findUser(username: String, password: String) : User?

    suspend fun updateToken(username: String, token: String)
}