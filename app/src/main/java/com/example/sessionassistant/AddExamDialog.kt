package com.example.sessionassistant

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import java.util.Locale

class AddExamDialogFragment : DialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.add_exam, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Добавляем обработчики событий для элементов пользовательского интерфейса
        val examDateET = view.findViewById<EditText>(R.id.exam_date_edit_text)
        val buttonDatePicker = view.findViewById<Button>(R.id.datePickerButton)
        buttonDatePicker.setOnClickListener {
            val activity = requireActivity()
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(activity, { _, year, month, day ->
                val date = "$day.${month + 1}.$year" // форматирование даты в строку
                examDateET.setText(date) // установка даты в EditText
            }, year, month, day)
            datePickerDialog.show()
        }
        val examTimeET = view.findViewById<EditText>(R.id.exam_time_edit_text)
        val buttonTimePicker = view.findViewById<Button>(R.id.timePickerButton)
        buttonTimePicker.setOnClickListener {
            val activity = requireActivity()
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val timePickerDialog = TimePickerDialog(activity, { _, hour, minute ->
                // обработка выбранного времени
                val selectedTime = "%02d:%02d".format(hour, minute)
                examTimeET.setText(selectedTime)
            }, hour, minute, true)
            timePickerDialog.show()
        }
        val buttonSave = view.findViewById<Button>(R.id.filledButton)
        buttonSave.setOnClickListener {
            // Обработка сохранения экзамена
            dismiss()
        }

        val buttonCancel = view.findViewById<Button>(R.id.textButton)
        buttonCancel.setOnClickListener {
            // Обработка отмены диалога
            dismiss()
        }

        val editTextExamName = view.findViewById<EditText>(R.id.exam_name_edit_text)

        val timePickerExamTime = view.findViewById<EditText>(R.id.exam_time_edit_text)
        val editTextExamLocation = view.findViewById<EditText>(R.id.exam_location_edit_text)
        val editTextExamScore = 0

        // Инициализируем поля диалога данными, если они есть
        // ...

    }
}
