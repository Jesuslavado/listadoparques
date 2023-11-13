package com.example.listadoparques.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listadoparques.Parque
import com.example.listadoparques.R

class ParqueAdapter (var parqueList: List<Parque>) : RecyclerView.Adapter<ParqueViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParqueViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ParqueViewHolder(layoutInflater.inflate(R.layout.itemparques,parent,false))
   }

    override fun getItemCount(): Int {
        return parqueList.size
    }

    override fun onBindViewHolder(holder: ParqueViewHolder, position: Int) {
        val item= parqueList[position]
        holder.render(item)    }

    fun actualizarParques(listaparque: List<Parque>) {
        this.parqueList = listaparque
        notifyDataSetChanged()
    }




}