package ru.frostovoi.data.message

import org.litote.kmongo.coroutine.CoroutineDatabase
import ru.frostovoi.data.model.Message

class MessageDataSourceImpl(
    db: CoroutineDatabase
) : MessageDataSource {


    private val messages = db.getCollection<Message>()

    override suspend fun getAllMessages(): List<Message> {
        return messages.find()
            .descendingSort(Message::timestamp)
            .toList()
    }

    override suspend fun insertMessage(message: Message) {
        messages.insertOne(message)
    }
}
