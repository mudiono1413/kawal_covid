package com.e.kawal_covid.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.e.kawal_covid.Model.ItemGlobalModel;
import com.e.kawal_covid.Model.ItemModel;
import com.e.kawal_covid.Model.ItemNegaraModel;
import com.e.kawal_covid.R;
import com.e.kawal_covid.ViewModel.AllDataViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.lblTtlPositif)
    TextView mTtlPositif;
    @BindView(R.id.lblTtlMeninggal)
    TextView mTtlMeninggal;
    @BindView(R.id.lblTtlSembuh)
    TextView mTtlSembuh;
    @BindView(R.id.lblTtlDataMeninggal)
    TextView mTotalDataMeninggal;
    @BindView(R.id.lblTtlDataPositif)
    TextView mTotalDataPositif;
    @BindView(R.id.lblTtlDataSembuh)
    TextView mTotalDataSembuh;

    private AllDataViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mViewModel = ViewModelProviders.of(this).get(AllDataViewModel.class);
        mViewModel.getDataPositif().observe(this, new Observer<ItemModel>() {
            @Override
            public void onChanged(ItemModel itemModel) {

                mTtlPositif.setText(itemModel.getValue());
            }
        });
        mViewModel.getDataMeninggal().observe(this, new Observer<ItemModel>() {
            @Override
            public void onChanged(ItemModel itemModel) {
                mTtlMeninggal.setText(itemModel.getValue());
            }
        });
        mViewModel.getDataSembuh().observe(this, new Observer<ItemModel>() {
            @Override
            public void onChanged(ItemModel itemModel) {
                mTtlSembuh.setText(itemModel.getValue());
            }
        });

        mViewModel.getDataNegara().observe(this, new Observer<List<ItemNegaraModel>>() {
            @Override
            public void onChanged(List<ItemNegaraModel> itemNegaraModels) {
                for (int i = 0; i < itemNegaraModels.size() ; i++) {
                    mTotalDataMeninggal.setText(itemNegaraModels.get(i).getMeniggal()+ " ");
                    mTotalDataPositif.setText(itemNegaraModels.get(i).getPositif() + " ");
                    mTotalDataSembuh.setText(itemNegaraModels.get(i).getSembuh() + " ");


                }
            }
        });

        mViewModel.getDataGlobal().observe(this, new Observer<List<ItemGlobalModel>>() {
            @Override
            public void onChanged(List<ItemGlobalModel> itemGlobalModels) {
            }
        });

    }


}
