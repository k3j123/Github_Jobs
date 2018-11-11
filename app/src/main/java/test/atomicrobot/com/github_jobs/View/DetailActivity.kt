package test.atomicrobot.com.github_jobs.View

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.widget.TextView
import test.atomicrobot.com.github_jobs.R

/**
 * Created by trong on 11/11/18.
 *
 * Class Description: Detail class basically displays the job description for the selected job, as well as removing
 * any html tags left from the api.
 */

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.github_job_description)
        val ss:String = intent.getStringExtra("jobDescription")
        setData(ss)
    }

    private fun setData(data: String) {
        val jobDescription = findViewById<TextView>(R.id.jobDescription)
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            jobDescription.text = Html.fromHtml(data, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            jobDescription.text = Html.fromHtml(data).toString()
        }
    }
}