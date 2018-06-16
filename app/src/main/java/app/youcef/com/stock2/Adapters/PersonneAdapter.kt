package app.youcef.com.stock2.Adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import app.youcef.com.stock2.Model.Personne
import app.youcef.com.stock2.R

/**
 * Created by hp on 17/04/2018.
 */
class PersonneAdapter(val context: Context, val personnes: List<Personne>):BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val personneView:View
        var holder:ViewHolder
        if(convertView==null)
        {
            personneView=LayoutInflater.from(context).inflate(R.layout.personne_list_item,null)
            holder= ViewHolder()
            holder.personneImage=personneView.findViewById(R.id.personneImage)
            holder.personneName=personneView.findViewById(R.id.personneName)
            personneView.tag=holder

        }else{
            holder=convertView.tag as ViewHolder
            personneView=convertView
        }


        val personne=personnes[position]
        holder.personneName?.text=personne.nomPrenom
        val resourceId=context.resources.getIdentifier(personne.photo,"drawable",context.packageName)
        holder.personneImage?.setImageResource(resourceId)
        return personneView
    }

    override fun getItem(position: Int): Any {
        return personnes[position]
    }

    override fun getItemId(position: Int): Long {
       return 0
    }

    override fun getCount(): Int {
        return personnes.count()
    }
    private class ViewHolder{
        var personneImage:ImageView?=null
        var personneName:TextView?=null

    }



}