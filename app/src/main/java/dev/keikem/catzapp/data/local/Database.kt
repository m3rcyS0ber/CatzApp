package dev.keikem.catzapp.data.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import dev.keikem.catzapp.data.local.dao.CatDao
import dev.keikem.catzapp.data.local.dao.DogDao
import dev.keikem.catzapp.data.local.entity.LocalCat
import dev.keikem.catzapp.data.local.entity.LocalDog


//Обьект базы данных
@Database(
    entities = [
        LocalCat::class,
        LocalDog::class,
    ],
    //После добавления новой сущности - увеличиваем версию
    version = 1,
    autoMigrations = [
        //После добавления новой сущности - увеличиваем версию и добавляем авто миграции по образцу ниже
        // AutoMigration(1, 2)
    ],
    exportSchema = true
)
abstract class Database : RoomDatabase() {
    abstract fun catDao(): CatDao

    abstract fun dogDao(): DogDao
}


