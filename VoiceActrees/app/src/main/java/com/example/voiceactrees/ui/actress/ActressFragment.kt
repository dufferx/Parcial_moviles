package com.example.voiceactrees.ui.actress

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.voiceactrees.R
import com.example.voiceactrees.databinding.FragmentActressBinding
import com.example.voiceactrees.ui.actress.viewmodel.ActressViewModel


class ActressFragment : Fragment() {

    private val viewModel: ActressViewModel by activityViewModels {
        ActressViewModel.Factory
    }

    private lateinit var binding: FragmentActressBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentActressBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()

    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }




}