package buu.informatics.s59160090.translateit


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160090.translateit.databinding.FragmentEndBinding
import buu.informatics.s59160090.translateit.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class EndFragment : Fragment() {
    var finalScore = ""

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
        val args = EndFragmentArgs.fromBundle(arguments!!)
        finalScore = args.score.toString()
        Toast.makeText(context, "Your Score is ${args.score}", Toast.LENGTH_LONG).show()
        binding.end = this
        setHasOptionsMenu(true)
        return binding.root
    }

    // Creating our Share Intent
    private fun getShareIntent() : Intent {
        val args = EndFragmentArgs.fromBundle(arguments!!)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, args.score))
        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.winner_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }



}
