package sk.upjs.ics.vma.mesacnik

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

typealias OnStringClickListener = (String, TextView) -> Unit

class StringViewHolder(itemView: View, onStringClickListener: OnStringClickListener) : RecyclerView.ViewHolder(itemView) {
    private val textView = itemView as TextView
    init {
        itemView.setOnClickListener {
            onStringClickListener(textView.text.toString(), textView)
        }
    }

    fun bind(value: String) {
        textView.text = value
        // nazov prechodu (Transition) je podľa textu na textovom políčku
        textView.transitionName = value
    }
}

object StringDiff : ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}

class StringAdapter(private val onStringClickListener: OnStringClickListener) : ListAdapter<String, StringViewHolder>(StringDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
            .let {
                StringViewHolder(it, onStringClickListener)
            }
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

val months = listOf(
    "január",
    "február",
    "marec",
    "apríl",
    "máj",
    "jún",
    "júl",
    "august",
    "september",
    "október",
    "november",
    "december"
)