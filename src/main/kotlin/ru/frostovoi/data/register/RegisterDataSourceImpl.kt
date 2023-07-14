package ru.frostovoi.data.register

import org.litote.kmongo.coroutine.CoroutineDatabase
import ru.frostovoi.data.model.User

class RegisterDataSourceImpl(
    db: CoroutineDatabase
) : RegisterDataSource {

    private val users = db.getCollection<User>()


    override suspend fun createNewUser(user: User) {
        users.insertOne(user)
    }
}
