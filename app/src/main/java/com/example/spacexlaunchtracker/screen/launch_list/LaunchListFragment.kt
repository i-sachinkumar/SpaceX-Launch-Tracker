package com.example.spacexlaunchtracker.screen.launch_list

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacexlaunchtracker.R
import com.example.spacexlaunchtracker.adapter.LaunchAdapter
import com.example.spacexlaunchtracker.api.RetrofitInstance
import com.example.spacexlaunchtracker.databinding.FragmentLaunchListBinding
import com.example.spacexlaunchtracker.model.Launch
import com.example.spacexlaunchtracker.prefrence.SharedPreferencesUtil
import com.example.spacexlaunchtracker.screen.detail_view.SharedViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaunchListFragment : Fragment() {

    private lateinit var binding: FragmentLaunchListBinding
    private lateinit var launchViewModel: LaunchViewModel
    private lateinit var launchAdapter: LaunchAdapter

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_launch_list, container, false)
        return binding.root
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        launchViewModel = ViewModelProvider(this)[LaunchViewModel::class.java]
        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        launchAdapter = LaunchAdapter(
            launchViewModel.launchList,
            {
                sharedViewModel.launch = it
                findNavController().navigate(R.id.action_fragment_launch_list_to_fragment_detail_view)
            },
            { position: Int, missionName: String ->
                val starred = SharedPreferencesUtil.getBoolean(missionName, false)
                SharedPreferencesUtil.putBoolean(missionName, !starred)
                launchAdapter.notifyItemChanged(position)
            }
        )

        binding.recyclerView.apply {
            adapter = launchAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        binding.searchView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let {
                    launchViewModel.filterLaunches(it.toString(), launchAdapter)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        launchViewModel.launches.observe(viewLifecycleOwner) {
            println(
                "data list changed" +
                        ", size: ${it?.size}"
            )
            if (it.isNullOrEmpty()) {
                println("empty data")
            } else {
                launchViewModel.launchList.clear()
                launchViewModel.launchList.addAll(it)
                launchAdapter.notifyDataSetChanged()
            }
        }

        launchViewModel.dataSize.observe(viewLifecycleOwner) {
            if (it == 0) binding.emptyResult.visibility = View.VISIBLE
            else binding.emptyResult.visibility = View.GONE
        }

        //progress indicator starting
        binding.progressBar.visibility = View.VISIBLE
        binding.emptyResult.visibility = View.GONE

        //getting data through api
        RetrofitInstance.api.getLaunches().enqueue(object : Callback<List<Launch>> {
            override fun onResponse(call: Call<List<Launch>>, response: Response<List<Launch>>) {
                if(response.isSuccessful) {
                    launchViewModel.launches.value = response.body()!!
                    launchViewModel.dataSize.value = response.body()!!.size
                }
                binding.progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<List<Launch>>, t: Throwable) {
                println("Error: ${t.message}")
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
                binding.progressBar.visibility = View.GONE
            }

        })

        binding.searchViewLayout.setEndIconOnClickListener {
            outFocusSearchView()
        }
        binding.searchViewLayout.isEndIconVisible = false
        binding.searchView.setOnFocusChangeListener { _, hasFocus ->
            binding.searchViewLayout.isEndIconVisible = hasFocus
            if (hasFocus) {
                if (!binding.starBtn.tag.equals("0")) {
                    binding.starBtn.performClick()
                }
            }
        }

        binding.starBtn.setOnClickListener {
            outFocusSearchView()
            if (binding.starBtn.tag.equals("0")) {
                binding.starBtn.setBackgroundResource(android.R.drawable.star_big_on)
                binding.starBtn.tag = "1"
                launchViewModel.filterStarredLaunches(true, launchAdapter)
            } else {
                binding.starBtn.setBackgroundResource(android.R.drawable.star_off)
                binding.starBtn.tag = "0"
                launchViewModel.filterStarredLaunches(false, launchAdapter)
            }
        }
    }

    private fun outFocusSearchView() {
        binding.searchView.text?.clear()
        val imm =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.searchView.windowToken, 0)
        // Clearing focus from the search view
        binding.searchView.clearFocus()
    }
}