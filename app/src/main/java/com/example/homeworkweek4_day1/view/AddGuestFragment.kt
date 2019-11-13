package com.example.homeworkweek4_day1.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.homeworkweek4_day1.R
import com.example.homeworkweek4_day1.database.GuestDatabase
import com.example.homeworkweek4_day1.database.GuestEntity
import kotlinx.android.synthetic.main.add_guest_fragment_layout.*

class AddGuestFragment : Fragment(){


    lateinit var fragmentListener: FragmentListener
    lateinit var database: GuestDatabase

    interface FragmentListener{
        fun updateGuestList()
    }

    fun setListener(fragmentListener: FragmentListener){
        this.fragmentListener = fragmentListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_guest_fragment_layout,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {fragmentActivity ->
            database = Room.databaseBuilder(fragmentActivity.applicationContext, GuestDatabase::class.java,"Guest.db")
                .allowMainThreadQueries()
                .build()
        }

        checkIn_button.setOnClickListener {
            val name = name_text.text.toString()
            val roomNumber = room_text.text.toString()
            val roomPrice = price_text.text.toString()
            val date = date_text.text.toString()
            val guest = GuestEntity(name,roomNumber,roomPrice,date)
            database.guestDAO().addNewGuest(guest)
            clearTextFields()
            fragmentListener.updateGuestList()
            fragmentManager?.popBackStack()
        }
    }



    private fun clearTextFields(){
        name_text.text.clear()
        room_text.text.clear()
        date_text.text.clear()
        price_text.text.clear()
    }

}