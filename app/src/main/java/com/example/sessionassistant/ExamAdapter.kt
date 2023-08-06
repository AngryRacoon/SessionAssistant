package com.example.sessionassistant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.entities.Exam

class ExamAdapter(private val exams: List<Exam>) : RecyclerView.Adapter<ExamAdapter.ExamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.exam_card_item, parent, false)
        return ExamViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExamViewHolder, position: Int) {
        val exam = exams[position]
        holder.bind(exam)
    }

    override fun getItemCount(): Int {
        return exams.size
    }

    inner class ExamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val examNameTextView: TextView = itemView.findViewById(R.id.textViewExamName)
        private val examDateTextView: TextView = itemView.findViewById(R.id.textViewExamDate)
        // Добавьте ссылки на другие элементы макета карточки экзамена, если требуется

        fun bind(exam: Exam) {
            examNameTextView.text = exam.exam_name
            examDateTextView.text = exam.exam_date.toString()
            // Привяжите другие данные экзамена к соответствующим элементам макета
        }
    }
}
