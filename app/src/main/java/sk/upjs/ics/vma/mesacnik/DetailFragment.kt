package sk.upjs.ics.vma.mesacnik

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

private const val TEXT_ARG = "text"
const val DETAIL_FRAGMENT_TAG = "Detail"

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private lateinit var detailTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        detailTextView = view.findViewById(R.id.detailTextView)
        arguments?.getString(TEXT_ARG)?.let(detailTextView::setText)
    }
    companion object {
        fun create(text: String): DetailFragment {
            return DetailFragment().apply {
                arguments = bundleOf(TEXT_ARG to text)
            }
        }
    }
}