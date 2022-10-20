package uz.aziz.mathematics.activity

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import com.microsoft.bing.speech.SpeechClientStatus
import com.microsoft.cognitiveservices.speechrecognition.*
//import com.microsoft.cognitiveservices.speech.SpeechConfig
import uz.aziz.mathematics.R
import uz.aziz.mathematics.adapter.FirstPageAdapter
import uz.aziz.mathematics.databinding.ActivityPageBinding
import uz.aziz.mathematics.models.FirstPageModel

class PageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val speechAudioFormat = SpeechAudioFormat()
//        val values = SpeechRecognitionMode.values()


//       val a=  SpeechRecognitionServiceFactory.createDataClient(this,
//            SpeechRecognitionMode.ShortPhrase,
//            "Salom",
//            object : ISpeechRecognitionServerEvents {
//                override fun onPartialResponseReceived(p0: String?) {
//                    Log.e("onPartial", p0.toString())
//                }
//
//                override fun onFinalResponseReceived(p0: RecognitionResult?) {
//                    Log.e("onFinal", p0?.RecognitionStatus.toString())
//                }
//
//                override fun onIntentReceived(p0: String?) {
//                    Log.e("onIntent", p0.toString())
//                }
//
//                override fun onError(p0: Int, p1: String?) {
//                    Log.e("error", p1.toString())
//                }
//
//                override fun onAudioEvent(p0: Boolean) {
//                    Log.e("onAudio", p0.toString())
//                }
//
//            },
//            ""
//        )
//        a.StreamTTS("azxon","Azizxon")
//        SpeechClientStatus.
//        for (value in values) {
//            println(value)
//        }

        val key = intent.getIntExtra("key", 0)
        when (key) {
            0 -> {
                Log.e("pageActivity", "key null")
            }
            1 -> {
                binding.rv.adapter =
                    FirstPageAdapter(loadFirst(), object : FirstPageAdapter.OnItemPageListener {
                        override fun onItemClick(firstPageModel: FirstPageModel, position: Int) {
                            startActivity(
                                Intent(
                                    this@PageActivity,
                                    FirstQuizActivity::class.java
                                ).putExtra("key", 1)
                            )
                        }

                    })
            }
            2 -> {

            }
            3 -> {

            }
        }
    }

    private fun loadFirst(): List<FirstPageModel> {
        val list = ArrayList<FirstPageModel>()
        list.add(FirstPageModel(0, "0 dan 20 gacha taqqoslang"))
        list.add(FirstPageModel(1, "10 dan 20 gacha qo'shish va ayirish"))
        list.add(FirstPageModel(1, "15 soni qushish va ayirish"))
        return list
    }
}