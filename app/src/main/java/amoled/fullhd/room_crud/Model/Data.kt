package amoled.fullhd.room_crud.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "Message")
data class Data(
    @PrimaryKey(autoGenerate = true)
    val SerialNumber:Int,
    var Message:String) : Parcelable
