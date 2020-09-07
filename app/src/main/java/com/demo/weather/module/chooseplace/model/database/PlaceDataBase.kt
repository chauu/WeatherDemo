package com.demo.weather.module.chooseplace.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.demo.weather.model.LocationTypeConverter
import com.demo.weather.model.Place
import com.demo.weather.module.chooseplace.model.dao.PlaceDao

@Database(entities = [Place::class], version = 1, exportSchema = false)
@TypeConverters(LocationTypeConverter::class)
abstract class PlaceDataBase : RoomDatabase(){
    abstract fun placeDao(): PlaceDao

    companion object {
        private var INSTANCE: PlaceDataBase? = null
        fun getInstance(context: Context): PlaceDataBase? {
            if (INSTANCE == null) {
                synchronized(PlaceDataBase::class.java) {
                    if(INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context,
                            PlaceDataBase::class.java,
                            "database"
                        ).build()
                    }
                }
            }
            return INSTANCE
        }
    }
}