package com.byjusassignement.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.byjusassignement.model.News

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewsList(movies: List<News>)

    @Query("SELECT * FROM News")
    fun getNewsList(): List<News>
}