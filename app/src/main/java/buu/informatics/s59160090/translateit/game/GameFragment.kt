package buu.informatics.s59160090.translateit.game

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import buu.informatics.s59160090.translateit.game.GameFragmentDirections
import buu.informatics.s59160090.translateit.R
import buu.informatics.s59160090.translateit.databinding.FragmentGameBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [GameFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    private lateinit var viewModel: GameViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,
            R.layout.fragment_game,container,false)
        Log.i("GameFragment", "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        binding.game = viewModel
        binding.lifecycleOwner = this
        viewModel.eventGameFinish.observe(this, Observer<Boolean> { hasFinished ->
            if (hasFinished) gameFinished()
        })
        viewModel.setQuestion()

        binding.ans1.setOnClickListener {
            // view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
            if (viewModel.qIndex <4){
                viewModel.checkAns(0)
                binding.invalidateAll()
            }else{
                viewModel.checkAns(0)
                gameFinished()

            }

        }
        binding.ans2.setOnClickListener {
            // view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
            if (viewModel.qIndex <4){
                viewModel.checkAns(1)
                binding.invalidateAll()
            }else{
                viewModel.checkAns(1)
                gameFinished()
            }
        }
        binding.ans3.setOnClickListener {
            // view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
            if (viewModel.qIndex <4){
                viewModel.checkAns(2)
                binding.invalidateAll()
            }else{
                viewModel.checkAns(2)
                gameFinished()
            }
        }
        binding.ans4.setOnClickListener {
            // view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
            if (viewModel.qIndex <4){
                viewModel.checkAns(3)
                binding.invalidateAll()
            }else{
                viewModel.checkAns(3)
                gameFinished()
            }
        }
        // Bind this fragment class to the layout



        // Set the onClickListener for the submitButton

        return binding.root
    }
    private fun gameFinished() {
        //view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToEndFragment2(viewModel.score))
        val action =
            GameFragmentDirections.actionGameFragmentToEndFragment2(viewModel.score)

        NavHostFragment.findNavController(this).navigate(action)
    }




}
