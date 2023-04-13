package com.example.myapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
        @PrimaryKey(autoGenerate = true) val user_id: Int,
        val username: String,
        val email: String,
        val password: String
)
