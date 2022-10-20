package uz.aziz.mathematics.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.aziz.mathematics.databinding.ActivityPartBinding

class PartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPartFirst.setOnClickListener {
            startActivity(Intent(this, PageActivity::class.java).putExtra("key",1))
        }
        binding.btnPartSecond.setOnClickListener {
            startActivity(Intent(this, PageActivity::class.java).putExtra("key",2))
        }
        binding.btnPartThird.setOnClickListener {
            startActivity(Intent(this, PageActivity::class.java).putExtra("key", 3))
        }
    }
}