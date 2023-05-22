package com.example.voiceactrees.ui.actress.newactress

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.voiceactrees.R
import com.example.voiceactrees.databinding.FragmentNewActressBinding
import com.example.voiceactrees.ui.actress.viewmodel.ActressViewModel

class NewActressFragment : Fragment() {

    private val viewModel: ActressViewModel by activityViewModels {
        ActressViewModel.Factory
    }

    private lateinit var binding: FragmentNewActressBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentNewActressBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun setViewModel(){
        binding.viewmodel = viewModel
    }

    private fun observeStatus(){
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when{
                status.equals(ActressViewModel.WRONG_INFORMATION) -> {
                    viewModel.clearStatus()
                }

                status.equals(ActressViewModel.ACTRESS_CREATED) ->{
                    viewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

}