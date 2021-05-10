package sk.upjs.ics.vma.mesacnik

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.transition.MaterialContainerTransform

private const val TEXT_ARG = "text"
const val DETAIL_FRAGMENT_TAG = "Detail"

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private lateinit var detailTextView: TextView

    private lateinit var noteText: TextInputLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = 300L
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(requireContext().themeColor(R.attr.colorSurface))
        }

        detailTextView = view.findViewById(R.id.detailTextView)
        arguments?.getString(TEXT_ARG)?.let {
            detailTextView.text = it
            detailTextView.transitionName = it
        }

        noteText = view.findViewById(R.id.noteText)
        noteText.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if(s.isNullOrEmpty()) {
                    noteText.error = "Poznámka je povinná"
                } else {
                    noteText.error = ""
                }
            }

        })
    }
    companion object {
        fun create(text: String): DetailFragment {
            return DetailFragment().apply {
                arguments = bundleOf(TEXT_ARG to text)
            }
        }
    }
}