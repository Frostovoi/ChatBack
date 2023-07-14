package ru.frostovoi.data.message

import ru.frostovoi.data.model.Message

interface MessageDataSource {

    suspend fun getAllMessages(): List<Message>

    suspend fun insertMessage(message: Message)

}
