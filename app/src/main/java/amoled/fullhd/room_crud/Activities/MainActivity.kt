package amoled.fullhd.room_crud.Activities

import amoled.fullhd.room_crud.Adapter.TodoAdapter
import amoled.fullhd.room_crud.Model.Data
import amoled.fullhd.room_crud.Model.MessageViewModel
import amoled.fullhd.room_crud.R
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRc:RecyclerView
    lateinit var Butt:Button
    lateinit var todoAdapter: TodoAdapter
    lateinit var messageViewModel: MessageViewModel

    private lateinit var newMsg:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Butt=findViewById(R.id.button)
        myRc=findViewById(R.id.TodoRV)
        newMsg=findViewById(R.id.newMessage)


        //Recyclerview
        todoAdapter= TodoAdapter(this)
        myRc.adapter=todoAdapter
        myRc.layoutManager = LinearLayoutManager(this)


        //getting data from ViewModel
        messageViewModel= ViewModelProvider(this).get(MessageViewModel::class.java)
       messageViewModel.readAllData.observe(this) {
            todoAdapter.setData(it)
       }



    }

    fun increment(view: View) {
        val Msg=newMsg.text

        if (Msg.isEmpty())
        {
            Toast.makeText(this,"Please Enter a Meassage",Toast.LENGTH_LONG).show()

        }
        else
        {
            val data=Data(0,Msg.toString())
            messageViewModel.addUser(data)
            newMsg.clearAnimation()
            newMsg.setText("")
        }

    }

}