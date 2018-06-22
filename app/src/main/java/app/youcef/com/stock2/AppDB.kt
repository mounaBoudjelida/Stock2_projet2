package app.youcef.com.stock2

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import app.youcef.com.stock2.Model.Filme


@Database(entities = arrayOf(Filme::class,FilmesLies::class),version = 1)
    abstract class AppDB: RoomDatabase() {

        abstract fun filmDao() : FilmeDAO
    }