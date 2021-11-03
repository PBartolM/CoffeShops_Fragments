package com.example.coffeshops_fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Cafe(val imagen:Int,val cadena: Int, val cadena2:Int )
class CafeAdapter(var items: ArrayList<Cafe>) : RecyclerView.Adapter<CafeAdapter.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var laImagen: ImageView
        private var texto: TextView
        private var subTexto: TextView
        private val rb: RatingBar
        private var puntos:TextView

        init {
            laImagen=itemView.findViewById(R.id.iv_image)
            texto = itemView.findViewById(R.id.textView1)
            subTexto=itemView.findViewById(R.id.textView3)
            rb= itemView.findViewById(R.id.ratingBar)
            puntos= itemView.findViewById(R.id.textView2)

        }

        fun bindTarjeta(t: Cafe, onClick: (View) -> Unit) = with(itemView) {
            laImagen.setImageResource(t.imagen)
            texto.setText(t.cadena)
            subTexto.setText(t.cadena2)
            setOnClickListener { onClick(itemView) }
            rb.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener{ ratingBar, rating, fromUser ->

                puntos.text = rb.rating.toString()

            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.cafe, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}