package buu.informatics.s59160090.translateit.score


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160090.translateit.R
import buu.informatics.s59160090.translateit.database.UserDatabase
import buu.informatics.s59160090.translateit.databinding.FragmentScoreBinding


/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {

    private lateinit var binding: FragmentScoreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentScoreBinding>(inflater,
            R.layout.fragment_score,container,false)
        val application = requireNotNull(this.activity).application
        val dataSource = UserDatabase.getInstance(application)?.UserDao
        val viewModelFactory = dataSource?.let { ScoreViewModelFactory(it, application) }
        val ScoreViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(ScoreViewModel::class.java)
        binding.text.setText(ScoreViewModel.nameui)
        binding.menuButton3.setOnClickListener {view : View ->
            view.findNavController().navigate(R.id.action_scoreFragment_to_mainMenuFragment2)
        }
        binding.scoreborad = ScoreViewModel






        binding.setLifecycleOwner(this)
        return binding.root
    }


}
