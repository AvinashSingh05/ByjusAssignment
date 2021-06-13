package com.byjusassignement.room.converter

import androidx.room.TypeConverter
import com.byjusassignement.model.Source
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

open class SourceConverter {
    @TypeConverter
    fun fromString(value: String): Source {
        val listType = object : TypeToken<Source>() {}.type
        return Gson().fromJson<Source>(value, listType)
    }

    @TypeConverter
    fun fromList(list: Source): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}