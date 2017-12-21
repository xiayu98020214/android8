package com.example.administrator.android8

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Administrator on 2017/12/21 0021.
 */
class MainAdapter(val items: ArrayList<ProgramItemData>, val context: Context) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val holder = ViewHolder(itemView)


        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.itemView.setOnClickListener{
            val intent = Intent(context, items.get(position).cls)
            context.startActivity(intent)

        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val title = itemView.find<TextView>(R.id.title)
        val title = itemView.findViewById<TextView>(R.id.title)
      //  val title = itemView.findViewById<>(R.id.title)

    }
}