package amoled.fullhd.room_crud.Model

import amoled.fullhd.room_crud.Room.MessageDatabase
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MessageViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData:LiveData<List<Data>>
    private val repositry:MessageRepo
    init {
        val userDao= MessageDatabase.getDatabase(application).msgDao()
        repositry= MessageRepo(userDao)
        readAllData=repositry.readAllData
    }

    fun addUser(data: Data)
    {
        viewModelScope.launch (Dispatchers.IO){
            repositry.addMsg(data)
        }
    }

    fun deleteM(data: Data)
    {
        viewModelScope.launch (Dispatchers.IO){
            repositry.delete(data)
        }
    }

    fun updateM(data: Data)
    {
        viewModelScope.launch (Dispatchers.IO){
            repositry.update(data)
        }
    }
}