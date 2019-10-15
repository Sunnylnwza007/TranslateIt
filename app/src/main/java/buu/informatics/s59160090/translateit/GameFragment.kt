package buu.informatics.s59160090.translateit

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160090.translateit.databinding.FragmentGameBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [GameFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,
            R.layout.fragment_game,container,false)

        binding.ans1.setOnClickListener {view : View ->
            view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
        }
        binding.ans2.setOnClickListener {view : View ->
            view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
        }
        binding.ans3.setOnClickListener {view : View ->
            view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
        }
        binding.ans4.setOnClickListener {view : View ->
            view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
        }

        return binding.root
    }



}
