package com.dicoding.makananlezatnusantara

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailFoodActivity : AppCompatActivity() {

    companion object {
        const val key_food = "key_food"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_food)

        val dataFood = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Food>(key_food, Food::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Food>(key_food)
        }

        val tvDetailItemName : TextView = findViewById(R.id.tv_detail_item_name)
        val tvDetailDescription : TextView = findViewById(R.id.tv_detail_description)
        val tvDetailHistorical : TextView = findViewById(R.id.tv_detail_historical)
        val imgDetailItemPhoto : ImageView = findViewById(R.id.img_detail_item_photo)

        if (dataFood != null) {
            tvDetailItemName.text = dataFood.name
            tvDetailDescription.text = dataFood.description
            tvDetailHistorical.text = dataFood.historical
            Glide.with(this)
                .load(dataFood.photo) // URL Gambar
                .into(imgDetailItemPhoto) // imageView mana yang akan diterapkan
        }
    }
}