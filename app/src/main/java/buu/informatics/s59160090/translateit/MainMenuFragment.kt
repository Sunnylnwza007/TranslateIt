package buu.informatics.s59160090.translateit


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
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

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }


}
