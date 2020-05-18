package id.pantaucovid_19

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.pandemi_indonesia.view.*
import kotlinx.android.synthetic.main.pandemi_internasional.view.*
import kotlinx.android.synthetic.main.pantau_covid_item.view.*

class PantauIndAdapter (
    private val context: Context,
    private val items:
    List<IndonesiPandemiItem>,
    private val listener: (IndonesiPandemiItem) -> Unit) :
    RecyclerView.Adapter<PantauIndAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            context, LayoutInflater.from(context).inflate(
                R.layout.pandemi_indonesia,
                parent,false
            )
        )

    override fun getItemCount() : Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position),listener)
    }
    class ViewHolder(val context: Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: IndonesiPandemiItem, listener: (IndonesiPandemiItem) -> Unit) {

            itemView.PsfCovid.text = item.positif
            itemView.diRs.text = item.dirawat
            itemView.psnSmbh.text = item.sembuh
            itemView.psnMninggal.text = item.meninggal

            containerView.setOnClickListener { listener(item) }

        }
    }
}