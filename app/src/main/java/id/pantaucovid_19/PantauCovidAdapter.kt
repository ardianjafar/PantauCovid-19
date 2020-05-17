package id.pantaucovid_19

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.pantau_covid_item.view.*

class PantauCovidAdapter(
    private val context: Context,
    private val items:
    List<KawalCoronaItem>,
    private val listener: (Attributes)-> Unit) :
    RecyclerView.Adapter<PantauCovidAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            context, LayoutInflater.from(context).inflate(
                R.layout.pantau_covid_item,
                parent, false
            )
        )

    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position).attributes,listener)
    }
    class ViewHolder(val context: Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: Attributes, listener: (Attributes) -> Unit) {

            itemView.txtProvinsi.text  = item.provinsi
            itemView.txtPositif.text  = item.kasusPosi.toString()
            itemView.txtSembuh.text = item.kasusSemb.toString()
            itemView.txtMeninggal.text = item.kasusMeni.toString()

            containerView.setOnClickListener { listener(item) }

        }
    }
}