package com.example.sessionassistant

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.entities.Exam

class ExamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val examNameTextView: TextView = itemView.findViewById(R.id.textViewExamName)
    private val examDateTextView: TextView = itemView.findViewById(R.id.textViewExamDate)
    private val examTimeTextView: TextView = itemView.findViewById(R.id.textViewExamTime)
    private val examLocationTextView: TextView = itemView.findViewById(R.id.textViewExamLocation)

    fun bind(exam: Exam) {
        examNameTextView.text = exam.exam_name
        examDateTextView.text = exam.exam_date.toString()
        examTimeTextView.text = exam.exam_time.toString()
        examLocationTextView.text = exam.exam_location
    }
}
