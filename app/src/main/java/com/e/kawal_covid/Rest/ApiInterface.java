package com.e.kawal_covid.Rest;

import com.e.kawal_covid.Model.ItemGlobalModel;
import com.e.kawal_covid.Model.ItemModel;
import com.e.kawal_covid.Model.ItemNegaraModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/positif")
    Call<ItemModel> getPositif();
    @GET("/sembuh")
    Call<ItemModel> getSembuh();
    @GET("/meninggal")
    Call<ItemModel> getMeninggal();
    @GET("/indonesia")
    Call<List<ItemNegaraModel>> getNegara();
    @GET("/")
    Call<List<ItemGlobalModel>> getGlobal();
}
