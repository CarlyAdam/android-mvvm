package com.carlyadam.kotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.carlyadam.kotlin.R
import com.carlyadam.kotlin.data.db.Person

class PersonAdapter(var person_list: List<Person>, var mContext: Context, var listener: AdapterListener) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when (holder) {

            is ViewHolder -> {
                holder.bind(person_list[position])
            }

        }
    }

    override fun getItemCount(): Int {
        return person_list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.textViewName)
        fun bind(person: Person) {
            name.text = person.name

        }
    }

    interface AdapterListener {
        fun onItemTap(position: Int)
    }

}

