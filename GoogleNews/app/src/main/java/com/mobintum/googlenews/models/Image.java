
package com.mobintum.googlenews.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("tbUrl")
    @Expose
    private String tbUrl;
    @SerializedName("originalContextUrl")
    @Expose
    private String originalContextUrl;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("tbWidth")
    @Expose
    private Integer tbWidth;
    @SerializedName("tbHeight")
    @Expose
    private Integer tbHeight;

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
     *     The tbUrl
     */
    public String getTbUrl() {
        return tbUrl;
    }

    /**
     * 
     * @param tbUrl
     *     The tbUrl
     */
    public void setTbUrl(String tbUrl) {
        this.tbUrl = tbUrl;
    }

    /**
     * 
     * @return
     *     The originalContextUrl
     */
    public String getOriginalContextUrl() {
        return originalContextUrl;
    }

    /**
     * 
     * @param originalContextUrl
     *     The originalContextUrl
     */
    public void setOriginalContextUrl(String originalContextUrl) {
        this.originalContextUrl = originalContextUrl;
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
     *     The tbWidth
     */
    public Integer getTbWidth() {
        return tbWidth;
    }

    /**
     * 
     * @param tbWidth
     *     The tbWidth
     */
    public void setTbWidth(Integer tbWidth) {
        this.tbWidth = tbWidth;
    }

    /**
     * 
     * @return
     *     The tbHeight
     */
    public Integer getTbHeight() {
        return tbHeight;
    }

    /**
     * 
     * @param tbHeight
     *     The tbHeight
     */
    public void setTbHeight(Integer tbHeight) {
        this.tbHeight = tbHeight;
    }

}
