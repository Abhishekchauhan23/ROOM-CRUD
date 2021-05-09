package amoled.fullhd.room_crud.Adapter

import amoled.fullhd.room_crud.Activities.CrudActivity
import amoled.fullhd.room_crud.Model.Data
import amoled.fullhd.room_crud.R
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.*
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

lateinit var alertDialog:AlertDialog
//private lateinit var messageViewModel: MessageViewModel
class TodoAdapter(val context: Context) : RecyclerView.Adapter<TodoAdapter.ViewHold>() {
    private var userList = emptyList<Data>()

    class ViewHold(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.ViewHold {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message, parent, false)
        return ViewHold(view)
    }

    override fun onBindViewHolder(holder: TodoAdapter.ViewHold, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.messageTv).text = userList[position].Message
        holder.itemView.findViewById<CardView>(R.id.msgCard)
            .setOnClickListener(View.OnClickListener {
                val intent = Intent(context,CrudActivity::class.java)
//                val parcelable:Parcelable=userList[position]
//                intent.putExtra("msg",parcelable)
                intent.putExtra("msg", userList[position]);
                context.startActivity(intent)

            })
        holder.itemView.findViewById<CardView>(R.id.msgCard).setOnLongClickListener {
            Toast.makeText(
                context,
                "Long Pressed ${userList[position].Message}",
                Toast.LENGTH_SHORT
            ).show()
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<Data>) {
        this.userList = user
        notifyDataSetChanged()
    }
}

