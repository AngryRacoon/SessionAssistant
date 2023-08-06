package com.example.sessionassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.entities.User
import database.AppDatabase
import database.dao.ExamDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val user = User(1,"anatoly", "dnjkdf@gmail.com","Ilya haed")
        GlobalScope.launch {
            AppDatabase.getInstance(this@MainActivity).insertUserIfNotExists(user)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        var badge = bottomNavigationView.getOrCreateBadge(R.id.item_2)
        badge.isVisible = true
        // An icon only badge will be displayed unless a number or text is set:
        badge.number = 99  // or badge.text = "New"
        bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.item_1 -> {
                    // Respond to navigation item 1 click
                    true
                }
                R.id.item_2 -> {
                    // Respond to navigation item 2 click
                    true
                }
                else -> false
            }
        }
        val button = findViewById<Button>(R.id.filledTonalButton)
        button.setOnClickListener {
            val dialog = AddExamDialogFragment()
            dialog.show(supportFragmentManager, "AddExamDialogFragment")
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        val examDao = AppDatabase.getInstance(applicationContext.applicationContext).examDao()
        CoroutineScope(Dispatchers.Main).launch {
            val exams = withContext(Dispatchers.IO) {
                examDao.getExams()
            }
        val adapter = ExamAdapter(exams)


// Установка LayoutManager для RecyclerView
        recyclerView.layoutManager = GridLayoutManager(applicationContext.applicationContext, 2)


// Установка адаптера для RecyclerView
        recyclerView.adapter = adapter

    }
    }
}

