package database.dao

import androidx.room.Dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapp.entities.Exam
import com.example.myapp.entities.User

@Dao
interface ExamDao {

    @Insert
    suspend fun insert(exam: Exam)

    @Update
    suspend fun update(exam: Exam)

    @Query("SELECT * FROM exam")
    suspend fun getExams(): List<Exam>


    @Delete
    suspend fun delete(exam: Exam)


}
