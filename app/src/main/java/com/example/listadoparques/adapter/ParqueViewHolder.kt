package com.example.listadoparques.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listadoparques.Parque
import com.example.listadoparques.databinding.ItemparquesBinding

class ParqueViewHolder (view: View): RecyclerView.ViewHolder(view) {
    val binding= ItemparquesBinding.bind(view)
    fun render(parquemodel:Parque)
    {
        binding.nombreparque.text= parquemodel.nombre
        binding.descripcion.text=parquemodel.descripcion
        Glide.with(binding.imagenparque.context).load(parquemodel.photo).into(binding.imagenparque)
        // EVENTO HACER CLICK SOBRE LA IMAGEN DE UNA PELICULA
        binding.imagenparque.setOnClickListener{
            Toast.makeText(binding.imagenparque.context, parquemodel.nombre, Toast.LENGTH_LONG).show()
        }
        // EVENTO HACER CLICK SOBRE TODA LA PELICULA
        itemView.setOnClickListener{
            Toast.makeText(binding.imagenparque.context, parquemodel.nombre, Toast.LENGTH_LONG).show()
        }
    }
}