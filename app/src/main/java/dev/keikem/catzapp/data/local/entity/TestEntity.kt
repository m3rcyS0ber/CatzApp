package dev.keikem.catzapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_entity")
data class TestEntity(
    @PrimaryKey val id: String
)