package com.example.quizapp.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.models.quiz
import com.example.quizapp.utils.colorpicker
import com.example.quizapp.utils.iconpicker

class quiz_adapter(val context: Context, val quizzes: List<quiz>) :
    RecyclerView.Adapter<quiz_adapter.Quizviewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Quizviewholder {
        val view = LayoutInflater.from(context).inflate(R.layout.quiz_items, parent, false)
        return Quizviewholder(view)
    }

    override fun getItemCount(): Int {
        return quizzes.size
    }

    override fun onBindViewHolder(holder: Quizviewholder, position: Int) {
        holder.titleview.text = quizzes[position].title
        holder.cardcontainer.setCardBackgroundColor(Color.parseColor(colorpicker.getcolor()))
        holder.iconview.setImageResource(iconpicker.getcolor())
        holder.itemView.setOnClickListener{
            Toast.makeText(context, quizzes[position].title, Toast.LENGTH_SHORT).show()
        }
    }

    inner class Quizviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleview: TextView = itemView.findViewById(R.id.quiztitle)
        var iconview: ImageView = itemView.findViewById(R.id.quizicon)
        var cardcontainer: CardView = itemView.findViewById(R.id.cardcontainer)
    }
}