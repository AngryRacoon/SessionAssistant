package database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.myapp.entities.Answer
import com.example.myapp.entities.AnswerResult
import com.example.myapp.entities.Exam
import com.example.myapp.entities.LearningSession
import com.example.myapp.entities.Question
import com.example.myapp.entities.User
import database.dao.ExamDao
import database.dao.UserDao

@Database(entities = [User::class,Exam::class, AnswerResult::class, Answer::class,Question::class,LearningSession::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun examDao(): ExamDao


    suspend fun insertUserIfNotExists(user: User) {
        val existingUser = userDao().getUser()
        if (existingUser == null) {
            userDao().insert(user)
        }
    }
    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
