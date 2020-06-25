package id.pantaucovid_19.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.pantaucovid_19.api.AttributesX
import id.pantaucovid_19.api.InternasionalPandemiItem
import id.pantaucovid_19.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.pandemi_internasional.view.*

class PantauIntrAdapter (
    private val context: Context,
    private val items:
        List<InternasionalPandemiItem>,
    private val listener: (AttributesX) -> Unit) :
        RecyclerView.Adapter<PantauIntrAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            context, LayoutInflater.from(context).inflate(
                R.layout.pandemi_internasional,
                parent, false
            )
        )

        override fun getItemCount() : Int {
            return items.size
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position).attributes,listener)
    }
        class ViewHolder(val context: Context, override val containerView : View) :
            RecyclerView.ViewHolder(containerView), LayoutContainer {
            fun bindItem(item: AttributesX, listener: (AttributesX) -> Unit) {

                itemView.txtNegara.text = item.countryRegion
                itemView.ItrPositif.text = item.active.toString()
                itemView.ItrSembuh.text = item.recovered.toString()
                itemView.ItrMeninggal.text = item.deaths.toString()

                containerView.setOnClickListener { listener(item) }
            }
        }
    }