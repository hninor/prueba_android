package com.example.hnino.biblioapps;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.hnino.biblioapps.business.AppBusiness;
import com.example.hnino.biblioapps.greendao.App;
import com.example.hnino.biblioapps.util.Constant;

public class AppDetailActivity extends Activity {

    private AppBusiness appBusiness;
    private App mApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_app_detail);

        TextView tvDetail = (TextView) findViewById(R.id.tvDetail);
        Long idApp = getIntent().getLongExtra(Constant.ID_APP, new Long(1));
        appBusiness = new AppBusiness(getApplicationContext());
        mApp = appBusiness.getAppById(idApp);

        tvDetail.setText(mApp.getSummary());
        tvDetail.setMovementMethod(new ScrollingMovementMethod());

    }
}
