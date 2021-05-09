package amoled.fullhd.room_crud.Room

import amoled.fullhd.room_crud.Model.Data
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Data::class],version = 2,exportSchema = true)
abstract class MessageDatabase : RoomDatabase()  {

    abstract fun msgDao():UserDao

    companion object
    {
        @Volatile
        private var INSTANCE:MessageDatabase?=null

        fun getDatabase(context: Context):MessageDatabase{
            val tempInstance= INSTANCE
            if (tempInstance!=null)
            {
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    MessageDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }

}