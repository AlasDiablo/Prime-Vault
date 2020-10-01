package fr.alasdiablo.warframeprimevault

import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main_item.view.*


class RelicAdapter(private val relics: List<Relic>, private val context: MainActivity) : RecyclerView.Adapter<RelicAdapter.RelicViewHolder>() {

    class RelicViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelicViewHolder {
        return RelicViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_main_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RelicViewHolder, position: Int) {
        val relic = relics[position]
        holder.itemView.activity_main_item_title.text = relic.name
        holder.itemView.activity_main_item_title.setTextColor(if (relic.vault) Color.RED else Color.GREEN)
        holder.itemView.activity_main_item_title.setOnClickListener {
            val i = Intent(context, RelicInfo::class.java)
            i.putExtra("title", relic.name)

            i.putExtra("common_1", relic.common_1)
            i.putExtra("common_2", relic.common_2)
            i.putExtra("common_3", relic.common_3)

            i.putExtra("uncommon_1", relic.uncommon_1)
            i.putExtra("uncommon_2", relic.uncommon_2)

            i.putExtra("rare_1", relic.rare_1)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int = relics.size
}