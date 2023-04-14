package com.example.myapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Exam::class,
            parentColumns = ["exam_id"],
            childColumns = ["exam_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Question(
        @PrimaryKey(autoGenerate = true) val question_id: Int,
        val exam_id: Int,
        val question_text: String,
        val total_attempts: Int,
        val incorrect_attempts: Int
    )