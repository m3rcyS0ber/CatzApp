package dev.keikem.catzapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.keikem.catzapp.data.local.dao.CatDao
import dev.keikem.catzapp.data.local.entity.LocalCat


//Обьект базы данных
@Database(
    entities = [
        LocalCat::class,
    ], version = 1
)
abstract class Database : RoomDatabase() {
    abstract fun catDao(): CatDao
}

