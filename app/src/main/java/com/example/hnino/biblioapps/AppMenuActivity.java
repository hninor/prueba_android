package com.example.hnino.biblioapps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;

import com.example.hnino.biblioapps.adapter.AbsListViewAdapter;
import com.example.hnino.biblioapps.business.AppBusiness;
import com.example.hnino.biblioapps.greendao.App;
import com.example.hnino.biblioapps.util.Constant;

import java.util.List;

public class AppMenuActivity extends AppCompatActivity {

    //controles
    private AbsListView absListView;

    //campos
    private AbsListViewAdapter adapter;
    private AppBusiness business;
    private List<App> appList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_menu);
        //Ajustes Action bar
        getSupportActionBar().setTitle(R.string.apps);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        //inicializando controles
        absListView = (AbsListView)findViewById(R.id.list_item);
        //Capturando datos enviados desde la anterior actividad
        String categoryName = getIntent().getStringExtra(Constant.CATEGORY);
        //Instanciando las clases de negocio
        business = new AppBusiness(getApplicationContext());
        appList = business.getAppsByCategory(categoryName);
        adapter = new AbsListViewAdapter(this, R.layout.item_abslistview, appList);
        absListView.setAdapter(adapter);



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

}
