package test.atomicrobot.com.github_jobs.Helper.Networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import test.atomicrobot.com.github_jobs.Helper.Model.GithubJobsModel

/**
 * Created by trong on 11/11/18.
 *
 * Class Description: Basic interface class that contains the API Constant
 * In this case a simple Get call
 */

interface APIConstants {
    @GET("positions.json")
    fun getJobSpecific(@Query("search") search: String): Call<List<GithubJobsModel>>
}