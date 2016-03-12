
package com.mobintum.googlenews.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelatedStory {

    @SerializedName("unescapedUrl")
    @Expose
    private String unescapedUrl;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("titleNoFormatting")
    @Expose
    private String titleNoFormatting;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("publishedDate")
    @Expose
    private String publishedDate;
    @SerializedName("signedRedirectUrl")
    @Expose
    private String signedRedirectUrl;
    @SerializedName("language")
    @Expose
    private String language;

    /**
     * 
     * @return
     *     The unescapedUrl
     */
    public String getUnescapedUrl() {
        return unescapedUrl;
    }

    /**
     * 
     * @param unescapedUrl
     *     The unescapedUrl
     */
    public void setUnescapedUrl(String unescapedUrl) {
        this.unescapedUrl = unescapedUrl;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The titleNoFormatting
     */
    public String getTitleNoFormatting() {
        return titleNoFormatting;
    }

    /**
     * 
     * @param titleNoFormatting
     *     The titleNoFormatting
     */
    public void setTitleNoFormatting(String titleNoFormatting) {
        this.titleNoFormatting = titleNoFormatting;
    }

    /**
     * 
     * @return
     *     The location
     */
    public String getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * 
     * @param publisher
     *     The publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * 
     * @return
     *     The publishedDate
     */
    public String getPublishedDate() {
        return publishedDate;
    }

    /**
     * 
     * @param publishedDate
     *     The publishedDate
     */
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    /**
     * 
     * @return
     *     The signedRedirectUrl
     */
    public String getSignedRedirectUrl() {
        return signedRedirectUrl;
    }

    /**
     * 
     * @param signedRedirectUrl
     *     The signedRedirectUrl
     */
    public void setSignedRedirectUrl(String signedRedirectUrl) {
        this.signedRedirectUrl = signedRedirectUrl;
    }

    /**
     * 
     * @return
     *     The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

}
