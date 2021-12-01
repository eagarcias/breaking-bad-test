package test.breaking.bad

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import test.breaking.bad.databinding.ItemCharacterBinding

class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemCharacterBinding.bind(view)

    fun bind(character: CharactersResponseItem) {
        //Picasso.get().load(character.img).into(binding.ivCharacter)
        Glide.with(itemView).load(character.img)
            .centerCrop()
            .into(binding.ivCharacter)
        binding.tvCharacterRealName.text = character.name
        binding.tvCharacterNickname.text = character.nickname
    }
}