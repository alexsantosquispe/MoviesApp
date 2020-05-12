package com.alexsantos.moviesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexsantos.moviesapp.Model.Superhero
import com.squareup.picasso.Picasso

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var superheros: MutableList<Superhero> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(superheros: MutableList<Superhero>, context: Context) {
        this.superheros = superheros
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = superheros.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.superhero_item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return superheros.size;
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val avatar = view.findViewById(R.id.shAvatar) as ImageView
        private val name = view.findViewById(R.id.shName) as TextView
        private val realName = view.findViewById(R.id.shRealName) as TextView
        private val publisher = view.findViewById(R.id.shPublisher) as TextView

        fun bind(superhero: Superhero, context: Context) {
            name.text = superhero.name
            realName.text = superhero.realName
            publisher.text = superhero.publisher
            Picasso.get().load(superhero.photo).into(avatar)
        }
    }
}