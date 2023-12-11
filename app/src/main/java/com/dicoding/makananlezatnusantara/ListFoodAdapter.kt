package com.dicoding.makananlezatnusantara

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.makananlezatnusantara.databinding.ItemRowFoodBinding

class ListFoodAdapter(private val listFood: ArrayList<Food>) : RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>(){

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowFoodBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, historical, photo) = listFood[position]
        Glide.with(holder.itemView.context)
            .load(photo) // URL Gambar
            .into(holder.binding.imgItemPhoto) // imageView mana yang akan diterapkan
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description

        holder.itemView.setOnClickListener{
//            onItemClickCallback.onItemClicked(listFood[holder.adapterPosition])
            val intentDetail = Intent(holder.itemView.context, DetailFoodActivity::class.java)
            intentDetail.putExtra("key_food", listFood[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }

    }

    override fun getItemCount(): Int = listFood.size

    class ListViewHolder(var binding: ItemRowFoodBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data: Food)
    }
}