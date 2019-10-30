package buu.informatics.s59160090.translateit.score


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160090.translateit.R
import buu.informatics.s59160090.translateit.databinding.FragmentScoreBinding
import buu.informatics.s59160090.translateit.database.DatabaseHandler

/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {
    var dbHandler: DatabaseHandler? = null
    private lateinit var binding: FragmentScoreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentScoreBinding>(inflater,
            R.layout.fragment_score,container,false)
        dbHandler = DatabaseHandler(getActivity())
        var user = dbHandler!!.getAllUsers()
        var score = dbHandler!!.getAllScore()
        Log.i("Score", "${user}")
        binding.text.setText(user)
        binding.score.setText(score)
        binding.menuButton3.setOnClickListener {view : View ->
            view.findNavController().navigate(R.id.action_scoreFragment_to_mainMenuFragment2)
        }





        return binding.root
    }


}
