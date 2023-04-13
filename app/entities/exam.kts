package com.example.myapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
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
data class Exam(
        @PrimaryKey(autoGenerate = true) val exam_id: Int,
        val user_id: Int,
        val exam_name: String,
        val exam_date: LocalDate,
        val exam_time: Long,
        val exam_location: String,
        val exam_score: Int
)
