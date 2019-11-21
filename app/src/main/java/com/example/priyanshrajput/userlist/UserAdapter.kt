package com.example.priyanshrajput.userlist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import BaseModel
import android.support.constraint.ConstraintLayout
import android.widget.TextView
import com.bumptech.glide.Glide

interface ItemClick {
    fun itemSelect(user: BaseModel)
}
class UserAdapter(val items : ArrayList<BaseModel>, val context: Context, val itemClick: ItemClick) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user, null, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item  = items.get(position)

        holder.tvFname.setText(item.first_name)
        holder.tvLname.setText(item.last_name)
        holder.tvEmail.setText(item.email)
        holder.tvGender.setText(item.gender)
        holder.tvAddress.setText(item.address)

        Glide.with(context)
                .load(item.profile_image)
                .centerCrop()
                .into(holder.ivUser);

        holder.main.setOnClickListener {
            itemClick.itemSelect(item)
        }

    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val ivUser = view.findViewById<ImageView>(R.id.ivUser)
    val tvFname: TextView = view.findViewById<TextView>(R.id.tvFname)
    val tvLname = view.findViewById<TextView>(R.id.tvLname)
    val tvEmail = view.findViewById<TextView>(R.id.tvEmail)
    val tvGender = view.findViewById<TextView>(R.id.tvGender)
    val tvAddress = view.findViewById<TextView>(R.id.tvAddress)
    val main = view.findViewById<ConstraintLayout>(R.id.main)
}