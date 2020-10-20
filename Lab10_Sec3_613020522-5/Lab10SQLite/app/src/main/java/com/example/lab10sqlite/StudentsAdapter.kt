package com.example.lab10sqlite

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.std_item_layout.view.*

class StudentsAdapter (val item:List<Student>, val context: Context):RecyclerView.Adapter<StudentsAdapter.ViewHolder>(){

    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val tvID : TextView =view.tv_id
        val tvName : TextView =view.tv_name
        val tvAge : TextView =view.tv_age
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate(R.layout.std_item_layout,parent,false)
        val myHolder = ViewHolder(view_item)

        view_item.setOnClickListener {
            val pos =myHolder.adapterPosition
            val context = parent.context
            val student = item[pos]
            val intent = Intent(context, EditDeleteActivity::class.java)
            intent.putExtra("mID",student.id)
            intent.putExtra("mName",student.name)
            intent.putExtra("mAge",student.age.toString())
            context.startActivity(intent)
        }

        return myHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvID.text = "ID: " + item[position].id
        holder.tvName.text ="Name: " + item[position].name
        holder.tvAge.text = "Age: " +item[position].age.toString()
    }

    override fun getItemCount(): Int {
        return item.size
    }


}