package com.e.kawal_covid.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ItemNegaraModel implements Serializable {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("positif")
    @Expose
    private String positif;

    @SerializedName("sembuh")
    @Expose
    private String sembuh;

    @SerializedName("meninggal")
    @Expose
    private String meniggal;


    public ItemNegaraModel(String name, String positif, String sembuh, String meniggal){
        this.name = name;
        this.positif = positif;
        this.sembuh = sembuh;
        this.meniggal = meniggal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositif() {
        return positif;
    }

    public void setPositif(String positif) {
        this.positif = positif;
    }

    public String getSembuh() {
        return sembuh;
    }

    public void setSembuh(String sembuh) {
        this.sembuh = sembuh;
    }

    public String getMeniggal() {
        return meniggal;
    }

    public void setMeniggal(String meniggal) {
        this.meniggal = meniggal;
    }
}
