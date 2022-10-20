package uz.aziz.mathematics.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.aziz.mathematics.databinding.FirstPageBinding
import uz.aziz.mathematics.models.FirstPageModel

class FirstPageAdapter(
    private val list: List<FirstPageModel>,
    private val listener: OnItemPageListener
) :
    RecyclerView.Adapter<FirstPageAdapter.MyFirstPageViewHolder>() {

    inner class MyFirstPageViewHolder(private val binding: FirstPageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(firstPageModel: FirstPageModel, position: Int) {
            binding.apply {
                tv.text = firstPageModel.text
            }
            itemView.setOnClickListener {
                listener.onItemClick(firstPageModel, position)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFirstPageViewHolder {
        return MyFirstPageViewHolder(
            FirstPageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyFirstPageViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
    interface OnItemPageListener {
        fun onItemClick(firstPageModel: FirstPageModel, position: Int)
    }
}