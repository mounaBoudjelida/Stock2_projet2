package app.youcef.com.stock2

import android.arch.persistence.room.TypeConverter
import app.youcef.com.stock2.Model.Filme
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson
import java.util.*
import java.util.Collections.EMPTY_LIST
import kotlin.collections.ArrayList


class DateRoomConverter {

    var gson = Gson()

    //convertir la liste des films associés en String
    @TypeConverter
    fun stringToAssociateMovie(data: String?): ArrayList<Filme>? {
        if (data == null) {
            return EMPTY_LIST as ArrayList<Filme>?
        }

        val listType = object : TypeToken<ArrayList<Filme>?>() {

        }.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun stringToAssociateMovie(someObjects: ArrayList<Filme>?): String {
        return gson.toJson(someObjects)
    }
}