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


    private AbsListView absListView;
    private AbsListViewAdapter adapter;
    private AppBusiness business;
    private List<App> appList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_menu);

        absListView = (AbsListView)findViewById(R.id.list_item);
        business = new AppBusiness(getApplicationContext());
        String categoryName = getIntent().getStringExtra(Constant.CATEGORY);
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
