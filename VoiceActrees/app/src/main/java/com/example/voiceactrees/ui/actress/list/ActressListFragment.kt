package com.example.voiceactrees.ui.actress.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.voiceactrees.R
import com.example.voiceactrees.data.model.ActreesModel
import com.example.voiceactrees.databinding.FragmentActressListBinding
import com.example.voiceactrees.ui.actress.list.recyclerview.ActressRecyclerViewAdapter
import com.example.voiceactrees.ui.actress.viewmodel.ActressViewModel

class ActressListFragment : Fragment() {

    private val viewModel: ActressViewModel by activityViewModels {
        ActressViewModel.Factory
    }

    private lateinit var binding: FragmentActressListBinding
    private lateinit var adapter: ActressRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentActressListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener {
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_actressListFragment_to_newActressFragment)

        }
    }

    private fun setRecyclerView(view: View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = ActressRecyclerViewAdapter { selectedActress ->
            showSelectedActress(selectedActress)
        }

        binding.recyclerView.adapter = adapter
        displayActresses()
    }

    private fun displayActresses(){
        adapter.setData(viewModel.getActresses())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedActress(actress: ActreesModel){
        viewModel.setSelectedActress(actress)
        findNavController().navigate(R.id.action_actressListFragment_to_actressFragment)
    }


}