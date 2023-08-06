package database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapp.entities.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM user LIMIT 1")
    fun getUser(): User?

}