package uz.aziz.mathematics.dialog

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import uz.aziz.mathematics.databinding.DialogResultBinding

class ResultDialog(var checkCount:Int,var errorCount:Int) : DialogFragment() {
    private lateinit var binding: DialogResultBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogResultBinding.inflate(inflater, container, false)
        binding.answers.text=" To'g'ri javoblar soni: $checkCount"
        binding.errors.text=" Noto'g'ri javoblar soni: $errorCount"
        binding.btnFinish.setOnClickListener {
            requireActivity().finish()
        }
        return binding.root
    }
}