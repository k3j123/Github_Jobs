package test.atomicrobot.com.github_jobs.Helper.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by trong on 11/11/18.
 *
 * Class description: Basic model schema created based on the data structure
 * returned from the API
 */

class GithubJobsModel {

    @SerializedName("id")
    @Expose
    private var id: String? = null
    @SerializedName("created_at")
    @Expose
    private var createdAt: String? = null
    @SerializedName("title")
    @Expose
    private var title: String? = null
    @SerializedName("location")
    @Expose
    private var location: String? = null
    @SerializedName("type")
    @Expose
    private var type: String? = null
    @SerializedName("description")
    @Expose
    private var description: String? = null
    @SerializedName("how_to_apply")
    @Expose
    private var howToApply: String? = null
    @SerializedName("company")
    @Expose
    private var company: String? = null
    @SerializedName("company_url")
    @Expose
    private var companyUrl: String? = null
    @SerializedName("company_logo")
    @Expose
    private var companyLogo: String? = null
    @SerializedName("url")
    @Expose
    private var url: String? = null

    fun getId(): String? {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }

    fun getCreatedAt(): String? {
        return createdAt
    }

    fun setCreatedAt(createdAt: String) {
        this.createdAt = createdAt
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getLocation(): String? {
        return location
    }

    fun setLocation(location: String) {
        this.location = location
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String) {
        this.type = type
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun getHowToApply(): String? {
        return howToApply
    }

    fun setHowToApply(howToApply: String) {
        this.howToApply = howToApply
    }

    fun getCompany(): String? {
        return company
    }

    fun setCompany(company: String) {
        this.company = company
    }

    fun getCompanyUrl(): String? {
        return companyUrl
    }

    fun setCompanyUrl(companyUrl: String) {
        this.companyUrl = companyUrl
    }

    fun getCompanyLogo(): String? {
        return companyLogo
    }

    fun setCompanyLogo(companyLogo: String) {
        this.companyLogo = companyLogo
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }

}
