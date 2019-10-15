package buu.informatics.s59160090.translateit


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160090.translateit.databinding.FragmentEndBinding
import buu.informatics.s59160090.translateit.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class EndFragment : Fragment() {
    private lateinit var binding: FragmentEndBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentEndBinding>(inflater,
            R.layout.fragment_end,container,false)
        binding.menuButton2.setOnClickListener {view : View ->
            view.findNavController().navigate(R.id.action_endFragment_to_mainMenuFragment2)
        }

        return binding.root
    }



}
