package test.breaking.bad

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CharactersAdapter (var characters:List<CharactersResponseItem>, var mContext: Context): RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(layoutInflater.inflate(R.layout.item_character, parent, false), mContext)

    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = characters[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = characters.size

}