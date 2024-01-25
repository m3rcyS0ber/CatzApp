package dev.keikem.catzappedit.data.repository

import dev.keikem.catzappedit.DatabaseHolder
import dev.keikem.catzappedit.data.local.entity.LocalCounter

class CounterRepository {

    private val database = DatabaseHolder.provideDb()
    fun loadFromLocal(): String? = database?.counterDao()?.get()?.countedNumber

    fun saveToLocal(counter: LocalCounter) {
        database?.counterDao()?.set(counter)
    }
}