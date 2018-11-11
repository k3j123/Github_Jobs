package test.atomicrobot.com.github_jobs.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.atomicrobot.com.github_jobs.Adapter.JobsAdapter
import test.atomicrobot.com.github_jobs.Helper.Model.GithubJobsModel
import test.atomicrobot.com.github_jobs.Helper.Networking.APIClient
import test.atomicrobot.com.github_jobs.Helper.Networking.APIConstants
import test.atomicrobot.com.github_jobs.R
import java.util.ArrayList

/**
 * Created by trong on 11/11/18
 *
 * Class Description: Main class that contains the recyclerview
 * The searchFunction method will wait until the user inputs a job term they want to search for
 * and once you click search will display a progressbar until the data is retrieved.
 * It will then set the progressbar to invisible and show the loaded in data.
 * If you are to search for another job, the method will clear the recyclerview first and display
 * the progressbar until new data is loaded.
 */

class MainActivity : AppCompatActivity() {

    private var jobAdapter: JobsAdapter? = null
    private val job = ArrayList<GithubJobsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.github_jobs_recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        jobAdapter = JobsAdapter(this, job)
        recyclerView.adapter = jobAdapter

        searchFunction()
    }

    private fun searchFunction() {
        val textBox = findViewById<EditText>(R.id.text_box)
        val submitButton = findViewById<Button>(R.id.submit_button)
        submitButton.setOnClickListener {
            job.clear()
            progress(true)
            jobAdapter?.notifyDataSetChanged()
            val apiInterface = APIClient.client.create(APIConstants::class.java)
            val jobListSpecificCall = apiInterface.getJobSpecific(textBox.text.toString())
            jobListSpecificCall.enqueue(object: Callback<List<GithubJobsModel>> {
                override fun onResponse(call: Call<List<GithubJobsModel>>?, response: Response<List<GithubJobsModel>>?) {
                    for (list: GithubJobsModel in response!!.body()!!){
                        job.add(list)
                    }
                    progress(false)
                    jobAdapter?.notifyDataSetChanged()
                }
                override fun onFailure(call: Call<List<GithubJobsModel>>?, t: Throwable?) {
                    Log.e("Response error", "error")
                }
            })
        }
    }

    private fun progress(bool: Boolean) {
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)

        if(bool) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

}
