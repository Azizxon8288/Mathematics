package uz.aziz.mathematics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.aziz.mathematics.activity.PartActivity
import uz.aziz.mathematics.databinding.ActivityMainBinding
import uz.aziz.mathematics.func.hideSystemUI

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideSystemUI(window, binding.root)
        supportActionBar?.hide()
        binding.button.setOnClickListener {
            startActivity(Intent(this, PartActivity::class.java))
        }

    }
}