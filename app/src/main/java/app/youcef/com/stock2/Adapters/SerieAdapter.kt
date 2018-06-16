package app.youcef.com.stock2.Adapters

import android.content.Context

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import app.youcef.com.stock2.Model.Serie
import app.youcef.com.stock2.R
/**
 * Created by hp on 19/04/2018.
 */
class SerieAdapter(val context:Context,val series:List<Serie>,val itemClick:(Serie)->Unit):RecyclerView.Adapter<SerieAdapter.SerieHolder>() {
    override fun getItemCount(): Int {
        return series.count()
    }

    override fun onBindViewHolder(holder: SerieHolder?, position: Int) {
        holder?.bindSerie(series[position],context)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SerieHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.serie_list_item,parent,false)
        return SerieHolder(view,itemClick)
    }

    inner class SerieHolder(itemView: View?,val itemClick:(Serie)->Unit) : RecyclerView.ViewHolder(itemView){
        val serieImage=itemView?.findViewById<ImageView>(R.id.imageSerie)
        val serieTitle=itemView?.findViewById<TextView>(R.id.titleSerie)
        fun bindSerie(serie:Serie,context: Context){
            val resourceId=context.resources.getIdentifier(serie.photo,"drawable",context.packageName)
            serieImage?.setImageResource(resourceId)
            serieTitle?.text=serie.title
            itemView.setOnClickListener{(itemClick(serie))}
        }
    }
}