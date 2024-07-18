package com.example.spacexlaunchtracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spacexlaunchtracker.R
import com.example.spacexlaunchtracker.model.Launch
import com.example.spacexlaunchtracker.prefrence.SharedPreferencesUtil

class LaunchAdapter(
    private val launches: List<Launch>,
    private val onItemClick: (Launch) -> Unit,
    private val onStarClick: (Int, String) -> Unit) : RecyclerView.Adapter<LaunchAdapter.LaunchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_launch_list, parent, false)
        return LaunchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return launches.size
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        val launch = launches[position]
        holder.bind(launch)
        holder.itemView.setOnClickListener {
            onItemClick(launch)
        }
        holder.starBtn.setOnClickListener {
            onStarClick(position, launch.missionName!!)
        }
    }

    class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val missionName: TextView = itemView.findViewById(R.id.mission_name)
        private val launchYear: TextView = itemView.findViewById(R.id.launch_year)
        private val rocketName: TextView = itemView.findViewById(R.id.rocket_name)
        val starBtn: Button = itemView.findViewById(R.id.star_btn)

        fun bind(launch: Launch) {
            missionName.text = launch.missionName
            launchYear.text = launch.launchYear
            rocketName.text = launch.rocket?.rocketName

            val starred = SharedPreferencesUtil.getBoolean(launch.missionName!!, false)
            if(starred){
                starBtn.setBackgroundResource(android.R.drawable.star_on)
            }
            else starBtn.setBackgroundResource(android.R.drawable.star_off)
        }
    }
}
