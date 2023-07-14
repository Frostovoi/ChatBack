package ru.frostovoi.data.login

import kotlinx.serialization.Serializable


@Serializable
data class LoginReceiveRemote(
    val login: String,
    val password: String,
    val token: String? = null
)


@Serializable
data class LoginResponseRemote(
    val token: String
)