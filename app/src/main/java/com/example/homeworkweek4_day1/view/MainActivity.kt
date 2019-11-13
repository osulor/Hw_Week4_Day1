package com.example.homeworkweek4_day1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.homeworkweek4_day1.R
import com.example.homeworkweek4_day1.adapter.GuestAdapter
import com.example.homeworkweek4_day1.database.GuestDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AddGuestFragment.FragmentListener {


    lateinit var guestDB: GuestDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     guestDB = Room.databaseBuilder(this,GuestDatabase::class.java,"Guest.db")
         .allowMainThreadQueries()
         .build()

        insert_button.setOnClickListener {
            val fragment = AddGuestFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_layout,fragment)
                .addToBackStack(fragment.tag)
                .commit()
        }

        setUpAdapter()

    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)

        if(fragment is AddGuestFragment){
            fragment.setListener(this)
        }
    }


    private fun setUpAdapter(){
        val adapter = GuestAdapter(guestDB.guestDAO().retrieveAllGuests())
        guests_view.adapter = adapter
        guests_view.layoutManager = LinearLayoutManager(this)
    }

    override fun updateGuestList() {
        setUpAdapter()
    }
}
