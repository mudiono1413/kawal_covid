package com.e.kawal_covid.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.e.kawal_covid.Model.ItemGlobalModel;
import com.e.kawal_covid.Model.ItemModel;
import com.e.kawal_covid.Model.ItemNegaraModel;
import com.e.kawal_covid.Rest.ApiClient;
import com.e.kawal_covid.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllDataViewModel extends AndroidViewModel {
    private MutableLiveData<ItemModel> mDataPositif = new MutableLiveData<>();
    private MutableLiveData<ItemModel> mDataSembuh = new MutableLiveData<>();
    private MutableLiveData<ItemModel> mDataMeninggal = new MutableLiveData<>();
    private MutableLiveData<List<ItemNegaraModel>> mDataNegara = new MutableLiveData<>();
    private MutableLiveData<List<ItemGlobalModel>> mDataGlobal = new MutableLiveData<>();

    ApiInterface mApi;

    public AllDataViewModel(@NonNull Application application) {
        super(application);
        mApi = ApiClient.getClient().create(ApiInterface.class);
        fetDataPositif();
        fetDataMeninggal();
        fetDataSembuh();
        fetDataNegara();
        fetchDataGlobal();
    }

    public LiveData<ItemModel> getDataPositif() {
        return mDataPositif;
    }

    public LiveData<ItemModel> getDataSembuh() {
        return mDataSembuh;
    }

    public LiveData<ItemModel> getDataMeninggal() {
        return mDataMeninggal;
    }

    public LiveData<List<ItemNegaraModel>> getDataNegara() {
        return mDataNegara;
    }

    public LiveData<List<ItemGlobalModel>> getDataGlobal(){
        return mDataGlobal;
    }

    public void fetDataPositif() {
        Call<ItemModel> call = mApi.getPositif();
        call.enqueue(new Callback<ItemModel>() {
            @Override
            public void onResponse(Call<ItemModel> call, Response<ItemModel> response) {
                if (response.isSuccessful()) {
                    mDataPositif.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ItemModel> call, Throwable t) {

            }
        });

    }

    public void fetDataSembuh() {
        Call<ItemModel> call = mApi.getSembuh();
        call.enqueue(new Callback<ItemModel>() {
            @Override
            public void onResponse(Call<ItemModel> call, Response<ItemModel> response) {
                if (response.isSuccessful()) {
                    mDataSembuh.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ItemModel> call, Throwable t) {

            }
        });

    }

    public void fetDataMeninggal() {
        Call<ItemModel> call = mApi.getMeninggal();
        call.enqueue(new Callback<ItemModel>() {
            @Override
            public void onResponse(Call<ItemModel> call, Response<ItemModel> response) {
                if (response.isSuccessful()) {
                    mDataMeninggal.postValue(response.body());
                }
                Log.d("kars", "where is data global sukses " );
            }

            @Override
            public void onFailure(Call<ItemModel> call, Throwable t) {
                Log.d("kars", "where is data global error " );
            }
        });

    }

    public void fetDataNegara() {
        Call<List<ItemNegaraModel>> call = mApi.getNegara();
        call.enqueue(new Callback<List<ItemNegaraModel>>() {
            @Override
            public void onResponse(Call<List<ItemNegaraModel>> call, Response<List<ItemNegaraModel>> response) {
                mDataNegara.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ItemNegaraModel>> call, Throwable t) {
            }
        });
    }

    public void  fetchDataGlobal(){
        Call<List<ItemGlobalModel>> call = mApi.getGlobal();
        call.enqueue(new Callback<List<ItemGlobalModel>>() {
            @Override
            public void onResponse(Call<List<ItemGlobalModel>> call, Response<List<ItemGlobalModel>> response) {
                Log.d("kars", "where is data global sukses: " + response.body());
                if (response.isSuccessful()){
                    mDataGlobal.postValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<ItemGlobalModel>> call, Throwable t) {

            }
        });
    }
}
