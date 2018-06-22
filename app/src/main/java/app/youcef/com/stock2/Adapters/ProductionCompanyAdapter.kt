package app.youcef.com.stock2.Adapters

import android.content.Context

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import app.youcef.com.stock2.Model.ProductionCompany
import app.youcef.com.stock2.R
import com.bumptech.glide.Glide

/**
 * Created by hp on 19/04/2018.
 */
class ProductionCompanyAdapter(val context:Context,val prodCompanies:List<ProductionCompany>,val itemClick:(ProductionCompany)->Unit):RecyclerView.Adapter<ProductionCompanyAdapter.ProductionCompanyHolder>() {
    override fun getItemCount(): Int {
        return prodCompanies.count()
    }

    override fun onBindViewHolder(holder: ProductionCompanyHolder?, position: Int) {
        holder?.bindProductionCompany(prodCompanies[position],context)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductionCompanyHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.company_list_item,parent,false)
        return ProductionCompanyHolder(view,itemClick)
    }

    inner class ProductionCompanyHolder(itemView: View?,val itemClick:(ProductionCompany)->Unit) : RecyclerView.ViewHolder(itemView){
        val productionCompanyImage=itemView?.findViewById<ImageView>(R.id.logoCompany)
        val productionCompanyTitle=itemView?.findViewById<TextView>(R.id.nameCompany)
        fun bindProductionCompany(prodCompany:ProductionCompany,context: Context){

            Glide.with(context).load(prodCompany.getlogo()).into(productionCompanyImage)
            productionCompanyTitle?.text=prodCompany.name
            itemView.setOnClickListener{(itemClick(prodCompany))}
        }
    }
}