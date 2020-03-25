package com.e.kawal_covid.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ItemGlobalModel implements Serializable {
    @SerializedName("attributes")
    @Expose
    private AttributesModel attributes;

    public AttributesModel getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributesModel attributes) {
        this.attributes = attributes;
    }
}
