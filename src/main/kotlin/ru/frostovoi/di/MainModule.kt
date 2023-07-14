package ru.frostovoi.di

import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo
import ru.frostovoi.data.login.LoginDataSource
import ru.frostovoi.data.login.LoginDataSourceImpl
import ru.frostovoi.data.message.MessageDataSource
import ru.frostovoi.data.message.MessageDataSourceImpl
import ru.frostovoi.data.register.RegisterDataSource
import ru.frostovoi.data.register.RegisterDataSourceImpl
import ru.frostovoi.room.RoomController

val mainModule = module {
    single {
        KMongo.createClient()
            .coroutine
            .getDatabase("message_db_yt")
    }
    single<MessageDataSource> {
        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
    single<LoginDataSource> {
        LoginDataSourceImpl(get())
    }

    single<RegisterDataSource> {
        RegisterDataSourceImpl(get())
    }
}