package amoled.fullhd.room_crud.Model

import amoled.fullhd.room_crud.Room.UserDao
import androidx.lifecycle.LiveData

class MessageRepo(private val userDao: UserDao) {

    val readAllData:LiveData<List<Data>> = userDao.readMsg()

    suspend fun addMsg(data: Data)
    {
        userDao.addMsg(data)
    }

    suspend fun delete(data: Data){
        userDao.deleteMsg(data)
    }

    suspend fun update(data: Data)
    {
        userDao.updateMsg(data)
    }
}