package com.example.myapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devanand.enficapp.databinding.UserDataItemBinding
import com.devanand.enficapp.modal.UserModal

class UserDataAdapter(val userDataList : List<UserModal>) : RecyclerView.Adapter<UserDataAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: UserDataItemBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(userDataList: UserModal) {

            binding.tvId.text = "Id : " + userDataList.id.toString()
            binding.tvName.text = "Name : " + userDataList.name
            binding.tvUserId.text = "lat : " + userDataList.address.geo.lat
            binding.tvTitle.text = "Lng : " + userDataList.address.geo.lng
            binding.tvBody.text = "Company Name : " + userDataList.company.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = UserDataItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userDataList[position])
        holder.adapterPosition
    }

    override fun getItemCount(): Int {
        return userDataList.size
    }
}