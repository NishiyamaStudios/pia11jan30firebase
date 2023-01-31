package se.nishiyamastudios.pia11jan30firebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FruitAdapter : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    var allfruit = mutableListOf<Fruit>()

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val fruitName: TextView

        init {

            fruitName = view.findViewById(R.id.fruitNameTV)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // viewType: Int = kan definiera olika typer av rader, produktrad, headerrad etc..



        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.fruitName.text = allfruit[position].fruitname

    }

    override fun getItemCount(): Int {
        return allfruit.size
    }

}