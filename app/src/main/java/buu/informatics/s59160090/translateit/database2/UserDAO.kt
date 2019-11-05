package buu.informatics.s59160090.translateit.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface UserDAO {
    @Insert()
    fun insert(user:User)

    @Query("SELECT * from users ORDER BY score DESC LIMIT 5")
    fun get1(): List<User?>

    @Query("SELECT * from users ORDER BY score DESC")
    fun getName(): User?

    @Query("SELECT * from users ORDER BY score DESC")
    fun getScore(): User?

    @Query("SELECT * FROM users ORDER BY score DESC LIMIT 5")
    fun getAll(): LiveData<List<User>>

    @Query("DELETE FROM users")
    fun clear()
}