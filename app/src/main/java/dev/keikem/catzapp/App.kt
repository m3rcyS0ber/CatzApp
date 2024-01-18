package dev.keikem.catzapp

import android.app.Application
import android.content.Context
import androidx.room.Room
import dev.keikem.catzapp.data.local.Database

//Класс, репрезентирующий само приложение
class App : Application()


//Обьект, отвечающии за создание/хранение бд
object DatabaseHolder {

    private var _database: Database? = null

    fun provideDb(context: Context) : Database {
        if (_database == null) {
            _database = Room.databaseBuilder(
                context,
                Database::class.java,
                "database.db"
            ).build()
        }
        return _database as Database
    }

}