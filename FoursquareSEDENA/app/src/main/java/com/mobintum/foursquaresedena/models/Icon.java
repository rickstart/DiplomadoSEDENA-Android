
package com.mobintum.foursquaresedena.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Icon {

    @SerializedName("prefix")
    @Expose
    private String prefix;
    @SerializedName("suffix")
    @Expose
    private String suffix;

    /**
     * 
     * @return
     *     The prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * 
     * @param prefix
     *     The prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * 
     * @return
     *     The suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * 
     * @param suffix
     *     The suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

}
