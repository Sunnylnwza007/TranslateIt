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
import buu.informatics.s59160090.translateit.databinding.FragmentMainPageBinding

class MainPage : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentMainPageBinding>(inflater,
            R.layout.fragment_main_page,container,false)
        binding.menuButton.setOnClickListener {view : View ->
            view.findNavController().navigate(R.id.action_mainPage_to_mainMenuFragment2)

        }

        return binding.root
    }


}
