package com.example.homeworkweek4_day1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkweek4_day1.R
import com.example.homeworkweek4_day1.database.GuestEntity
import com.example.homeworkweek4_day1.model.Guest

class GuestAdapter(private val guestList: List<GuestEntity>): RecyclerView.Adapter<GuestAdapter.GuestViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.guest_item_view,parent,false)
        return GuestViewHolder(view)
    }

    override fun getItemCount(): Int {
        return guestList.size
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {

        val guest = guestList[position]

        holder.apply {
            guestName.text = guest.guestName
            roomNumber.text = guest.roomNumber
            roomPrice.text = guest.roomPrice
            date.text = guest.date
        }

    }


    inner class GuestViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val guestName = itemView.findViewById<TextView>(R.id.name_textView)
        val roomNumber = itemView.findViewById<TextView>(R.id.room_textView)
        val roomPrice = itemView.findViewById<TextView>(R.id.price_textView)
        val date = itemView.findViewById<TextView>(R.id.date_textView)

    }
}