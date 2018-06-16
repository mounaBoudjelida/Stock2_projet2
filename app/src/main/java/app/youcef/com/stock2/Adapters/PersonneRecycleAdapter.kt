package app.youcef.com.stock2.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import app.youcef.com.stock2.Model.Personne
import app.youcef.com.stock2.R

/**
 * Created by hp on 17/04/2018.
 */
class PersonneRecycleAdapter(val context:Context,val personnes:List<Personne>,val itemClick:(Personne)->Unit):RecyclerView.Adapter<PersonneRecycleAdapter.Holder>() {
    override fun getItemCount(): Int {
        return personnes.count()
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindPersonne(personnes[position],context)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view=LayoutInflater.from(context)
                .inflate(R.layout.personne_list_item,parent,false)
        return Holder(view,itemClick)
    }

    inner class Holder(itemView: View?,val itemClick:(Personne)->Unit) : RecyclerView.ViewHolder(itemView) {
        val personneImage=itemView?.findViewById<ImageView>(R.id.personneImage)
        val personneName=itemView?.findViewById<TextView>(R.id.personneName)
        fun bindPersonne(personne:Personne,context:Context){
            val resourceId=context.resources.getIdentifier(personne.photo,"drawable",context.packageName)
            personneImage?.setImageResource(resourceId)
            personneName?.text=personne.nomPrenom
            itemView.setOnClickListener {
                itemClick(personne)
            }
        }
    }
}