package com.example.spacexlaunchtracker.screen.detail_view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.spacexlaunchtracker.R
import com.example.spacexlaunchtracker.databinding.FragmentDetailViewBinding

class DetailViewFragment : Fragment() {

    private lateinit var binding: FragmentDetailViewBinding
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_view, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        binding.viewmodel = sharedViewModel

        println("success ${sharedViewModel.launch?.launchSuccess}")
        if(sharedViewModel.launch!!.launchSuccess == true){
            binding.launchSuccess.text = "Launch succeeded"
        }
        else binding.launchSuccess.text = "Launch failed"

        if(sharedViewModel.launch?.launchSuccess == false){
            binding.failureReason.text = "Reason of failure: ${sharedViewModel.launch?.launchFailureDetails?.reason}"
        }
    }
}