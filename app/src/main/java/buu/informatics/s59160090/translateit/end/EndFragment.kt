package buu.informatics.s59160090.translateit.end


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59160090.translateit.R
import buu.informatics.s59160090.translateit.database.User
import buu.informatics.s59160090.translateit.database.UserDatabase


import buu.informatics.s59160090.translateit.databinding.FragmentEndBinding




/**
 * A simple [Fragment] subclass.
 */
class EndFragment : Fragment() {

    private lateinit var viewModelFactory: EndViewModelFactory

    private lateinit var binding: FragmentEndBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("GameFragment", "Called ViewModelProviders.of")

        val binding = DataBindingUtil.inflate<FragmentEndBinding>(inflater,
            R.layout.fragment_end,container,false)
        val application = requireNotNull(this.activity).application
        val args = EndFragmentArgs.fromBundle(arguments!!)
        val dataSource = UserDatabase.getInstance(application)?.UserDao
        val viewModelFactory = dataSource?.let { EndViewModelFactory(it, application) }
        val EndrViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(EndViewModel::class.java)
        EndrViewModel.score = args.score
        EndrViewModel.finalScore = args.score.toString()

        // Inflate the layout for this fragment




        binding.menuButton2.setOnClickListener {view : View ->
            var newUser = User()
            var text = binding.nameValue.getText().toString()
            binding.invalidateAll()
            EndrViewModel.name = text
            newUser.name = EndrViewModel.name
            Log.i("end","${EndrViewModel.name}")

            newUser.score = EndrViewModel.score

            EndrViewModel.callInsert(newUser)
            view.findNavController().navigate(R.id.action_endFragment_to_mainMenuFragment2)
        }

        Toast.makeText(context, "Your Score is ${args.score}", Toast.LENGTH_LONG).show()
        binding.end = EndrViewModel

        setHasOptionsMenu(true)
        binding.setLifecycleOwner(this)
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
