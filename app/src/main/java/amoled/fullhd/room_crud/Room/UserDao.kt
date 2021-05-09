package amoled.fullhd.room_crud.Room

import amoled.fullhd.room_crud.Model.Data
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMsg(data:Data)

    @Query("SELECT * FROM Message ORDER BY SerialNumber DESC")
    fun readMsg() : LiveData<List<Data>>

    @Delete
    suspend fun deleteMsg(data: Data)

    @Update
    suspend fun updateMsg(data: Data)

}