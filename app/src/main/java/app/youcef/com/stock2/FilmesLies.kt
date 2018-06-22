package app.youcef.com.stock2

import android.arch.persistence.room.Entity



@Entity(primaryKeys = arrayOf("idFilmeP","idFilmeD"))
class FilmesLies(
        var idFilmeP :Int,
        var idFilmeD :Int
) {}