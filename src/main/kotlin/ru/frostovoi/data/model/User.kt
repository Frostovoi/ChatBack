package ru.frostovoi.data.model

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@kotlinx.serialization.Serializable
data class User(
    val username: String,
    val password: String,
    val token: String,
    @BsonId
    val id: String = ObjectId().toString(),
)
