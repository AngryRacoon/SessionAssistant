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
        ),
        ForeignKey(
            entity = Question::class,
            parentColumns = ["question_id"],
            childColumns = ["question_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Answer(
    @PrimaryKey(autoGenerate = true) val answer_id: Int,
    val question_id: Int,
    val user_id: Int,
    val answer_text: String,
    val timestamp: Long
)
