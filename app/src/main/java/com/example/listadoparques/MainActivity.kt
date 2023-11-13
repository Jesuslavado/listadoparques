package com.example.listadoparques

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadoparques.adapter.ParqueAdapter
import com.example.listadoparques.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val decoration= DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recicler.layoutManager=LinearLayoutManager(this)
        binding.recicler.adapter=ParqueAdapter(ParqueProvider.parqueList)
        var adapter=ParqueAdapter(ParqueProvider.parqueList)
        binding.recicler.adapter=adapter

        binding.filtro.addTextChangedListener { filtro ->
            val filtroParque = ParqueProvider.parqueList.filter { parque ->
                parque.nombre.contains(filtro.toString())
            }
        }
        binding.filtro.addTextChangedListener {filtro ->
            val filtroParque = ParqueProvider.parqueList.filter { parque ->
                parque.nombre.contains(filtro.toString()) }
            adapter.actualizarParques(filtroParque)
        }

        binding.filtro.addTextChangedListener {filtro ->
            val filtroParque = ParqueProvider.parqueList.filter { parque ->
                parque.nombre.lowercase().contains(filtro.toString().lowercase()) }
            adapter.actualizarParques(filtroParque)
        }
    }

    
}