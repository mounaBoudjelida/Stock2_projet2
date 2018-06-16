package app.youcef.com.stock2.Adapters

import android.content.Context

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import app.youcef.com.stock2.Model.Salle
import app.youcef.com.stock2.R
/**
 * Created by hp on 19/04/2018.
 */
class SalleAdapter(val context:Context, val salles:List<Salle>):RecyclerView.Adapter<SalleAdapter.SalleHolder>() {
    override fun getItemCount(): Int {
       return salles.count()
    }

    override fun onBindViewHolder(holder: SalleHolder?, position: Int) {
       holder?.bindSerie(salles[position],context)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SalleHolder {
       val view=LayoutInflater.from(context).inflate(R.layout.salle_list_item,parent,false)
        return SalleHolder(view)
    }

    inner class SalleHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){
        val salleImage=itemView?.findViewById<ImageView>(R.id.imageSalle)
        val salleNom=itemView?.findViewById<TextView>(R.id.salleNom)
        val salleAdresse=itemView?.findViewById<TextView>(R.id.salleAdresse)
        fun bindSerie(salle:Salle,context: Context){
            val resourceId=context.resources.getIdentifier(salle.photo,"drawable",context.packageName)
            salleImage?.setImageResource(resourceId)
            salleNom?.text=salle.nom
            salleAdresse?.text=salle.adr
        }
    }
}