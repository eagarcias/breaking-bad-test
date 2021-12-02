package test.breaking.bad

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.ScaleAnimation
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import test.breaking.bad.databinding.ItemCharacterBinding


class CharacterViewHolder(view: View, var mContext: Context) : RecyclerView.ViewHolder(view) {

    private val binding = ItemCharacterBinding.bind(view)

    fun bind(character: CharactersResponseItem) {
        configureButtonAnimation()
        Glide.with(itemView).load(character.img)
            .centerCrop()
            .into(binding.ivCharacter)
        binding.tvCharacterRealName.text = character.name
        binding.tvCharacterNickname.text = character.nickname
        itemView.setOnClickListener{
            val intent = Intent(itemView.context, CharacterDetailActivity::class.java)
            intent.putExtra("character", character)
            mContext.startActivity(intent)
        }
    }

    private fun configureButtonAnimation() {
        var scaleAnimation = ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f, Animation.RELATIVE_TO_SELF, 0.7f, Animation.RELATIVE_TO_SELF, 0.7f)
        scaleAnimation.duration = 500
        var bounceInterpolator = BounceInterpolator()
        scaleAnimation.interpolator = bounceInterpolator

        binding.buttonFavorite.setOnCheckedChangeListener(object:View.OnClickListener, CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                p0?.startAnimation(scaleAnimation);
                Log.d("fav", "am i here") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onClick(p0: View?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        });
    }
}
