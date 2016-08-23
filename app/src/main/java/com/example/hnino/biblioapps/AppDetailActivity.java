package com.example.hnino.biblioapps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import com.example.hnino.biblioapps.business.AppBusiness;
import com.example.hnino.biblioapps.greendao.App;
import com.example.hnino.biblioapps.util.Constant;

public class AppDetailActivity extends AppCompatActivity {

    private AppBusiness appBusiness;
    private App mApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_app_detail);



        TextView tvDetail = (TextView) findViewById(R.id.tvDetail);
        Long idApp = getIntent().getLongExtra(Constant.ID_APP, new Long(1));
        appBusiness = new AppBusiness(getApplicationContext());
        mApp = appBusiness.getAppById(idApp);

        tvDetail.setText(mApp.getSummary());

    }
}
