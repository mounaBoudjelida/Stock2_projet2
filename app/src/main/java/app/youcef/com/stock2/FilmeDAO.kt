package app.youcef.com.stock2


import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import app.youcef.com.stock2.Model.Filme

@Dao
interface FilmeDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFilmeLies(filmesLies: FilmesLies)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFilme(filme : Filme)

    @Query("SELECT * from Filme")
    fun getFilmes() : List<Filme>


    @Query("select f.* from Filme as f join FilmesLies as fl on (f.id = fl.idFilmeP or f.id = idFilmeD) where f.id<>:id")

    fun getFilmeLies(id:Int) : List<Filme>


    @Query("select * from Filme as f where f.id=:id")
    fun getFilmeDetail(id:Int):Filme

}