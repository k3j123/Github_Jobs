package test.atomicrobot.com.github_jobs.Adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import test.atomicrobot.com.github_jobs.Helper.Model.GithubJobsModel
import test.atomicrobot.com.github_jobs.R
import test.atomicrobot.com.github_jobs.View.DetailActivity
import java.util.ArrayList

/**
 * Created by trong on 11/11/18.
 *
 * Class Description: Adapter Class for recyclerview. Binds basic data for application,
 * Company Name, Company Log, Job Title and Job Location
 * Private function goToJobDetails will start a new activity that will show the job description
 * of the selected job
 */

class JobsAdapter(private val context: Context, private var jobList: ArrayList<GithubJobsModel>) : RecyclerView.Adapter<JobsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.github_job_cell, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.companyName.text = jobList[position].getCompany()
        holder.jobTitle.text = jobList[position].getTitle()
        holder.jobLocation.text = jobList[position].getLocation()

        holder.companyLogo.let {
            Glide
                    .with(context)
                    .load(jobList[position].getCompanyLogo())
                    .into(it)
        }
        holder.layout.setOnClickListener({
            goToJobDetails(jobList[position].getDescription()!!)
        })
    }

    override fun getItemCount(): Int {
        return this.jobList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val companyLogo: ImageView = itemView.findViewById(R.id.companyLogo)
        val companyName: TextView = itemView.findViewById(R.id.companyName)
        val jobTitle: TextView = itemView.findViewById(R.id.jobTitle)
        val jobLocation: TextView = itemView.findViewById(R.id.location)
        val layout: LinearLayout = itemView.findViewById(R.id.layout)

        init {
            ButterKnife.bind(this, itemView)

            itemView.setOnClickListener { Toast.makeText(context, "selected", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun goToJobDetails(description: String) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("jobDescription", description)
        ContextCompat.startActivity(context, intent, null)
    }
}
