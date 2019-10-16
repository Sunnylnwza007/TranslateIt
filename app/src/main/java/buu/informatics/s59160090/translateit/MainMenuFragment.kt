package buu.informatics.s59160090.translateit


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160090.translateit.databinding.FragmentMainMenuBinding

/**
 * A simple [Fragment] subclass.
 */
class MainMenuFragment : Fragment() {
    private lateinit var binding: FragmentMainMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate<FragmentMainMenuBinding>(inflater,
            R.layout.fragment_main_menu,container,false)

        binding.playButton.setOnClickListener {view : View ->
            view.findNavController().navigate(R.id.action_mainMenuFragment_to_gameFragment2)

        }
        binding.scoreButton.setOnClickListener {view : View ->
            view.findNavController().navigate(R.id.action_mainMenuFragment_to_scoreFragment2)

        }


        return binding.root
    }


}
