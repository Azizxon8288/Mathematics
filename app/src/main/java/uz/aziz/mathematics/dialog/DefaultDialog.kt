package uz.aziz.mathematics.dialog

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import uz.aziz.mathematics.R
import uz.aziz.mathematics.databinding.DialogDefaultBinding

class DefaultDialog(val isCorrect: Boolean) : DialogFragment() {
    private var _binding: DialogDefaultBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogDefaultBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent);
        if (isCorrect) {
            binding.image.setImageResource(R.drawable.correct)
        } else {
            binding.image.setImageResource(R.drawable.error)
        }
        if (_binding != null) {
            Handler(Looper.getMainLooper()).postDelayed({
                dismiss()
            }, 200)
        } else {
            Log.e("binding", "binding is null")
        }
        return binding.root
    }
}