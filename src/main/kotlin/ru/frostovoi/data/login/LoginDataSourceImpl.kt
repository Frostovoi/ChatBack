package ru.frostovoi.data.login

import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq
import org.litote.kmongo.setValue
import ru.frostovoi.data.model.User


class LoginDataSourceImpl (
    db : CoroutineDatabase
): LoginDataSource {

    private val users = db.getCollection<User>()

    override suspend fun findUser(username: String, password: String): User? {
        return users.findOne(User::username eq username)
    }

    override suspend fun updateToken(username: String, token: String) {
        users.updateOne(User::username eq username, setValue(User::token, token))
    }

}