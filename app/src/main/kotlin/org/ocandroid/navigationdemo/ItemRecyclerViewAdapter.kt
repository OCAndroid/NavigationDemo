package org.ocandroid.navigationdemo

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController

import org.ocandroid.navigationdemo.dummy.DummyContent.DummyItem

import kotlinx.android.synthetic.main.fragment_item.view.*


class ItemRecyclerViewAdapter(
    private val mValues: List<DummyItem>
) : RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content

        with(holder.view) {
            setOnClickListener {
                val action = ItemFragmentDirections.actionItemToItemDetails(item.id)
                findNavController().navigate(action)
                //findNavController().navigate(R.id.itemDetailsFragment)
            }
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.item_number
        val contentView: TextView = view.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}
