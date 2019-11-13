package com.example.homeworkweek4_day1.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(version = 1, entities = [GuestEntity::class])
abstract class GuestDatabase: RoomDatabase(){

    abstract fun guestDAO(): GuestDAO
}