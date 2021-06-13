package com.byjusassignement.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(primaryKeys = [("title")])
data class News(
    var title : String,
    var description : String,
    var content : String,
    var url : String,
    var urlToImage : String,
    var publishedAt : String,
    var source : Source

): Parcelable
