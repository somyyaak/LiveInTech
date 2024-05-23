package Models

import com.example.liveintech.R

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class QuotesAdapter(private val context: Context, private val itemsData: ArrayList<Result?>) :
    RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): QuotesViewHolder {

        val v1: View = LayoutInflater.from(context)
            .inflate(R.layout.item_layout, p0, false)
        return QuotesViewHolder(v1)
    }

    override fun getItemCount(): Int {
        return itemsData.size
    }

    override fun onBindViewHolder(p0: QuotesViewHolder, p1: Int) {

        p0.quote.text = itemsData[p1]?.content
        p0.date.text = itemsData[p1]?.dateAdded
        p0.author.text = itemsData[p1]?.authorSlug

    }
        fun update(updatedData: List<Result?>) {
            itemsData.clear()
            itemsData.addAll(updatedData)
            notifyDataSetChanged()
        }




    class QuotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var quote: TextView = itemView.findViewById(R.id.content)
        var date: TextView = itemView.findViewById(R.id.dateadded)
        var author: TextView = itemView.findViewById(R.id.authorslug)
    }
}