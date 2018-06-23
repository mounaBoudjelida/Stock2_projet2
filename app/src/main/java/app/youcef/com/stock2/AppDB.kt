package app.youcef.com.stock2

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import app.youcef.com.stock2.Model.Filme


@Database(entities = arrayOf(Filme::class,FilmesLies::class),version = 1)
@TypeConverters(DateRoomConverter::class)
    abstract class AppDB: RoomDatabase() {

        abstract fun filmDao() : FilmeDAO
    }