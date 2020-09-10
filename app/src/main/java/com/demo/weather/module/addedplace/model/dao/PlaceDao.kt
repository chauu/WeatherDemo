package com.demo.weather.module.addedplace.model.dao

import androidx.room.*
import com.demo.weather.model.Place

@Dao
interface PlaceDao {
    @Transaction
    @Insert(entity = Place::class)
    suspend fun insertPlace(place: Place) : Long

    @Transaction
    @Query("SELECT * FROM place")
    suspend fun queryAllPlace() : MutableList<Place>

    @Transaction
    @Query("SELECT * FROM place WHERE name = (:name)")
    suspend fun queryPlaceByName(name: String) : Place?

    @Transaction
    @Query("SELECT * FROM place order by primaryKey desc")
    suspend fun queryFirstPlace() : Place?

    @Transaction
    @Delete(entity = Place::class)
    suspend fun deleteArticle(place: Place): Int

    @Transaction
    @Query("DELETE FROM place")
    suspend fun deleteAll()
}