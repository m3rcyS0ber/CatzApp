package dev.keikem.catzapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.keikem.catzapp.data.local.dao.CatDao
import dev.keikem.catzapp.data.local.dao.DogDao
import dev.keikem.catzapp.data.local.entity.LocalCat
import dev.keikem.catzapp.data.local.entity.LocalDog
import dev.keikem.catzapp.data.local.entity.TestEntity


//Обьект базы данных
@Database(
    entities = [
        LocalCat::class,
        LocalDog::class,
        TestEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class Database : RoomDatabase() {
    abstract fun catDao(): CatDao

    abstract fun dogDao(): DogDao
}

