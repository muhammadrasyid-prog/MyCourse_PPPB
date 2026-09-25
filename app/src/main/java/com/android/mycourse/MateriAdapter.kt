package com.android.mycourse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MateriAdapter(private val listMateri: List<MateriItem>) :
    RecyclerView.Adapter<MateriAdapter.MateriViewHolder>() {

    class MateriViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nomor: TextView = view.findViewById(R.id.tv_nomor)
        val judul: TextView = view.findViewById(R.id.tv_judul_materi)
        val deskripsi: TextView = view.findViewById(R.id.tv_deskripsi_materi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MateriViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_materi, parent, false)
        return MateriViewHolder(view)
    }

    override fun onBindViewHolder(holder: MateriViewHolder, position: Int) {
        val item = listMateri[position]
        holder.nomor.text = (position + 1).toString()
        holder.judul.text = item.judul
        holder.deskripsi.text = item.deskripsi
    }

    override fun getItemCount(): Int = listMateri.size
}