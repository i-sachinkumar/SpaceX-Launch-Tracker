package com.example.spacexlaunchtracker.screen.launch_list

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.spacexlaunchtracker.adapter.LaunchAdapter
import com.example.spacexlaunchtracker.model.Launch
import com.example.spacexlaunchtracker.prefrence.SharedPreferencesUtil
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LaunchViewModel(application: Application) : AndroidViewModel(application) {
    // will be used in Adapter
    val launchList: MutableList<Launch> = mutableListOf()

    //will hold all values
    val launches = MutableLiveData<List<Launch>>()
    val dataSize = MutableLiveData<Int>(0)

    init {
        launches.value = mutableListOf()
    }

    private var filterJob: Job? = null

    @SuppressLint("NotifyDataSetChanged")
    fun filterLaunches(query: String, adapter: LaunchAdapter) {
        // Cancel the previous filter request if it's still active
        filterJob?.cancel()

        // Start a new coroutine for the new query
        filterJob = viewModelScope.launch {
            if (query.isEmpty() || query.isBlank()) {
                launchList.clear()
                launchList.addAll(launches.value!!)
                dataSize.value = launchList.size
                adapter.notifyDataSetChanged()
                return@launch
            }
            val filteredList = launches.value?.filter {
                it.missionName?.contains(query, ignoreCase = true) == true
            }
            launchList.clear()
            launchList.addAll(filteredList!!)
            dataSize.value = launchList.size
            adapter.notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filterStarredLaunches(showStarred: Boolean, adapter: LaunchAdapter) {
        // Cancel the previous filter request if it's still active
        filterJob?.cancel()

        // Start a new coroutine for the new query
        filterJob = viewModelScope.launch {
            if (!showStarred) {
                launchList.clear()
                launchList.addAll(launches.value!!)
                dataSize.value = launchList.size
                adapter.notifyDataSetChanged()
                return@launch
            }
            val filteredList = launches.value?.filter {
                SharedPreferencesUtil.getBoolean(it.missionName!!, false)
            }
            launchList.clear()
            launchList.addAll(filteredList!!)
            dataSize.value = launchList.size
            adapter.notifyDataSetChanged()
        }
    }

}
