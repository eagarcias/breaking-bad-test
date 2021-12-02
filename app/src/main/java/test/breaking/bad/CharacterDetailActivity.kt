package test.breaking.bad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.ScaleAnimation
import android.widget.CompoundButton
import com.bumptech.glide.Glide
import test.breaking.bad.databinding.ActivityCharacterDetailBinding
import test.breaking.bad.databinding.ActivityMainBinding

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterDetailBinding
    private lateinit var character : CharactersResponseItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        character = intent.extras?.get("character") as CharactersResponseItem
        configureButtonAnimation()
        title = character.name
        Glide.with(this).load(character.img)
            .centerCrop()
            .into(binding.ivCharacter)
        binding.tvCharacterRealName.text = character.nickname
        binding.tvCharacterOccupation.text = character.occupation.joinToString(separator = ", ")
        binding.tvCharacterStatus.text = character.status
        binding.tvCharacterPortrayed.text = character.portrayed
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}