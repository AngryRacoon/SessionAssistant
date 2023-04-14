package com.example.myapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

import androidx.room.ForeignKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class LearningSession(
        @PrimaryKey(autoGenerate = true) val session_id: Int,
        val user_id: Int,
        val start_time: Long,
        val end_time: Long,
        val questions_count: Int,
    )
