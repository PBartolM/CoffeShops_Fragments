package com.example.coffeshops_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeshops_fragments.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val items = ArrayList<Cafe>()
        items.add(Cafe(R.drawable.images,R.string.titulo,R.string.subtitulo))
        items.add(Cafe(R.drawable.images1,R.string.titulo1,R.string.subtitulo1))
        items.add(Cafe(R.drawable.images2,R.string.titulo2,R.string.subtitulo2))
        items.add(Cafe(R.drawable.images3,R.string.titulo3,R.string.subtitulo3))
        items.add(Cafe(R.drawable.images4,R.string.titulo4,R.string.subtitulo4))
        items.add(Cafe(R.drawable.images5,R.string.titulo5,R.string.subtitulo5))
        items.add(Cafe(R.drawable.images6,R.string.titulo6,R.string.subtitulo6))

        val recView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recView.setHasFixedSize(true)
        recView.itemAnimator = DefaultItemAnimator()
        val adaptador = CafeAdapter(items)
        recView.adapter = adaptador

        recView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adaptador.onClick = {
            val i = items[recView.getChildAdapterPosition(it)]
            val bundlee = bundleOf("NOM" to resources.getString(i.cadena))

            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundlee)

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}