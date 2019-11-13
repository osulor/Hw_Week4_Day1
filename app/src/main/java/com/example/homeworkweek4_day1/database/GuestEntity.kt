package com.example.homeworkweek4_day1.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Guests")
class GuestEntity(
    @PrimaryKey(autoGenerate = true) var guestID: Int?,
    @ColumnInfo(name = "guestName") val guestName: String,
    @ColumnInfo(name = "roomNumber") val roomNumber: String,
    @ColumnInfo(name = "roomPrice") val roomPrice: String,
    @ColumnInfo(name = "date") val date: String
) {
    constructor(guestName: String, roomNumber: String, roomPrice: String ,date: String) : this(null, guestName, roomNumber, roomPrice,date)
}