package sk.upjs.ics.vma.mesacnik

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MasterFragment : Fragment(R.layout.fragment_master) {
    private lateinit var fab: FloatingActionButton

    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fab = view.findViewById(R.id.fab)
        fab.setOnClickListener {
            TODO("Obsluzit klik")
        }

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.adapter = StringAdapter { text, textView ->
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.activity_main, DetailFragment.create(text), DETAIL_FRAGMENT_TAG)
                addToBackStack(DETAIL_FRAGMENT_TAG)
            }
        }.apply {
            submitList(months)
        }
    }
}