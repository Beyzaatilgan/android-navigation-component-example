package com.beyzaatilgan.fragmentvenavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.Navigator
import com.beyzaatilgan.fragmentvenavigation.databinding.FragmentBirinciBinding


class BirinciFragment : Fragment() {

    private var _binding: FragmentBirinciBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBirinciBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
//fragment kullandığım zaman bu metodun içerisinde değişiklikleri yapabilirim.onCreate metodunun içerisinde hata alırım.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editText.setText("")
        binding.button.setOnClickListener{
            sonraki(it)
        }
        //Toast.makeText(this, "Hoşgeldiniz!", Toast.LENGTH_LONG).show()
        //context için hata verir çünkü buraya activite veya app contexini vermem lazım.
        Toast.makeText(requireContext(),"Hoşgeldiniz!",Toast.LENGTH_LONG ).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun sonraki (view: View){
        val isim = binding.editText.text.toString()
        val action = BirinciFragmentDirections.actionBirinciFragmentToIkinciFragment(isim)
        Navigation.findNavController(view).navigate(action)

    }


}