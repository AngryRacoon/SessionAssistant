package com.example.myapp.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = LearningSession::class,
            parentColumns = ["session_id"],
            childColumns = ["learning_session_id"],
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
data class AnswerResult(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val learning_session_id: Int,
    val question_id: Int,
    val is_correct: Boolean,
)
