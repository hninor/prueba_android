package com.example.hnino.biblioapps.application;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.hnino.biblioapps.greendao.DaoMaster;
import com.example.hnino.biblioapps.greendao.DaoSession;

import java.io.File;


/**
 * Created by hnino on 06/04/2016.
 */
public class AppContext extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        daoSession = initDB(this);
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }



    private static DaoSession initDB(Context ctx)
    {
        //DevOpenHelper helper = new DevOpenHelper(ctx, "wmsmp-db", null);
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(ctx, ctx.getExternalFilesDir(null).getAbsoluteFile().toString()
                + File.separator + "AppBiblio", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoMaster.newSession();
        return daoMaster.newSession();
    }
}
