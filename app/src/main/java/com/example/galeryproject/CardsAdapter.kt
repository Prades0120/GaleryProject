package com.example.galeryproject

import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CardsAdapter(private var items: ArrayList<Tarjeta>) : Adapter<CardsAdapter.TarjViewHolder>() {
    lateinit var onLongClick: (View) -> Unit

    class TarjViewHolder(itemView: View) : ViewHolder(itemView), View.OnCreateContextMenuListener {

        private var texto: TextView = itemView.findViewById(R.id.textViewCard)
        private var imagen: ImageView = itemView.findViewById(R.id.imageView2)

        init {
            itemView.setOnCreateContextMenuListener(this)
        }
        override fun onCreateContextMenu(
            menu: ContextMenu,
            v: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            menu.add(0,0,adapterPosition,"Editar")
            menu.add(0,1,adapterPosition,"Eliminar")
            menu.add(0,2,adapterPosition,"Compartir")
        }

         fun bindTarjeta(t: Tarjeta, onLongClick: (View) -> Unit) = with(itemView){
             texto.text = t.cadena
             imagen.setImageResource(t.imagen)
             setOnLongClickListener { onLongClick(itemView)
                                        true}
         }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items[pos]
        viewHolder.bindTarjeta(item, onLongClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}