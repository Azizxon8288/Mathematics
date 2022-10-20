package uz.aziz.mathematics.activity

import android.media.MediaPlayer
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.Voice
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.aziz.mathematics.R
import uz.aziz.mathematics.databinding.ActivityFirstQuizBinding
import uz.aziz.mathematics.dialog.DefaultDialog
import uz.aziz.mathematics.dialog.ResultDialog
import uz.aziz.mathematics.models.FirstPartModel
import java.util.*

class FirstQuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstQuizBinding
    private var index = 0
    private lateinit var quizList: ArrayList<FirstPartModel>
    private lateinit var tts: TextToSpeech
    private var checkCount = 0
    private var errorCount = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        tts = TextToSpeech(this) {
            if (it != TextToSpeech.ERROR) {
                val res: Int = tts.setLanguage(Locale.forLanguageTag("uz - UZ"))
                if (res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "Language not Supporter")
                }
                tts.language = Locale.ROOT
            }
        }
//        for (availableLocale in Locale.getAvailableLocales()) {
//            println(availableLocale.displayCountry + " -> " + availableLocale.displayLanguage)
//        }
//        for (isoLanguage in Locale.getISOLanguages()) {
//            println(isoLanguage)
//        }

        setQuestion()

        binding.btnVoiceText.setOnClickListener {
            val quiz = quizList[index]
            tts.speak(quiz.question, TextToSpeech.QUEUE_FLUSH, null, null)
            val create = MediaPlayer.create(this, R.raw.animation)
            create.start()
            create.prepare()
        }
        binding.btnFirst.setOnClickListener {
            check(binding.btnFirst.text.toString())
        }
        binding.btnSecond.setOnClickListener {
            check(binding.btnSecond.text.toString())
        }
        binding.btnThird.setOnClickListener {
            check(binding.btnThird.text.toString())
        }
        binding.btnFourth.setOnClickListener {
            check(binding.btnFourth.text.toString())
        }
    }

    private fun check(text: String) {
        val quiz = quizList[index]
        if (text == quiz.rightAnswer) {
            DefaultDialog(true).show(supportFragmentManager, "show")
            checkCount++
//            Toast.makeText(this, "Tugri", Toast.LENGTH_SHORT).show()
        } else {
            DefaultDialog(false).show(supportFragmentManager, "show")
            errorCount++
//            Toast.makeText(this, "NoTugri", Toast.LENGTH_SHORT).show()
        }
        index++
        setQuestion()
    }

    private fun setQuestion() {
        if (quizList.size > index) {
            val index = quizList[index]
            binding.textQuestion.text = index.question
            binding.btnFirst.text = index.answerFirst
            binding.btnSecond.text = index.answerSecond
            binding.btnThird.text = index.answerThird
            binding.btnFourth.text = index.answerFourth
        } else {
            val resultDialog = ResultDialog(checkCount, errorCount)
            resultDialog.isCancelable = false
            resultDialog.show(supportFragmentManager, "show")
        }
    }

    private fun loadData() {
        quizList = ArrayList()
        quizList.add(FirstPartModel(0, "14 + 2 = ?", "12", "14", "16", "13", "16"))
        quizList.add(FirstPartModel(0, "17 + 2 = ?", "15", "18", "16", "19", "19"))
        quizList.add(FirstPartModel(0, "15 - 4 = ?", "11", "18", "16", "13", "11"))
    }
}