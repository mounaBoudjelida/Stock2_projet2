package app.youcef.com.stock2.Adapters

import android.content.Context

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import app.youcef.com.stock2.Model.Filme
import app.youcef.com.stock2.R
/**
 * Created by hp on 19/04/2018.
 */
class FilmeAdapter(val context:Context,val filmes:List<Filme>,val itemClick:(Filme)->Unit):RecyclerView.Adapter<FilmeAdapter.FilmeHolder>() {
    override fun getItemCount(): Int {
        return filmes.count()
    }

    override fun onBindViewHolder(holder: FilmeHolder?, position: Int) {
        holder?.bindFilme(filmes[position],context)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FilmeHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.filme_list_item,parent,false)
        return FilmeHolder(view,itemClick)
    }

    inner class FilmeHolder(itemView: View?,val itemClick:(Filme)->Unit) : RecyclerView.ViewHolder(itemView){
        val filmeImage=itemView?.findViewById<ImageView>(R.id.imageFilme)
        val filmeTitle=itemView?.findViewById<TextView>(R.id.titleFilme)
        fun bindFilme(filme:Filme,context: Context){
            val resourceId=context.resources.getIdentifier(filme.photo,"drawable",context.packageName)
            filmeImage?.setImageResource(resourceId)
            filmeTitle?.text=filme.title
            itemView.setOnClickListener{(itemClick(filme))}
        }
    }
}