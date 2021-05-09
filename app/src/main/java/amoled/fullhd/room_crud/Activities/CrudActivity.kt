package amoled.fullhd.room_crud.Activities

import amoled.fullhd.room_crud.Model.Data
import amoled.fullhd.room_crud.Model.MessageViewModel
import amoled.fullhd.room_crud.R
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider

class CrudActivity : AppCompatActivity() {

    lateinit var updateText: EditText
    lateinit var update:Button
    lateinit var delete:Button

    private lateinit var msgViewModel: MessageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)
        updateText=findViewById(R.id.updateEt)
        update=findViewById(R.id.updateBtn)
        delete=findViewById(R.id.deleteBtn)

        msgViewModel=ViewModelProvider(this).get(MessageViewModel::class.java)
       // val intent= intent
//       val item = intent.getParcelableExtra("extra")
        if (getSupportActionBar() != null) {
            getSupportActionBar()?.hide();
        }
        val intent: Intent = getIntent()
        val datMessage: Data? =intent.getParcelableExtra("msg")
        val ms= datMessage?.Message.toString()
        updateText.setText(ms)


        delete.setOnClickListener(View.OnClickListener {
            val intent: Intent = getIntent()
            val datC: Data? =intent.getParcelableExtra("msg")
            val ms= datC?.Message.toString()

            if (datC != null) {
                msgViewModel.deleteM(datC)
                Toast.makeText(this,"DElETED: $ms",Toast.LENGTH_SHORT).show()
            }
        })

        update.setOnClickListener(View.OnClickListener {
            val intent: Intent = getIntent()
            val datC: Data? =intent.getParcelableExtra("msg")

            val updatedMsg=updateText.text.toString()
            if (updatedMsg.isEmpty())
            {
              Toast.makeText(this,"Enter Text",Toast.LENGTH_SHORT).show()
            }
            else
            {
                if (datC != null) {
                    datC.Message=updatedMsg
                    msgViewModel.updateM(datC)
                }

            }



        })

    }



}


