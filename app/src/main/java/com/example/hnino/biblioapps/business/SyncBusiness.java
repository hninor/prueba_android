package com.example.hnino.biblioapps.business;

import android.content.Context;
import android.database.Cursor;

import com.example.hnino.biblioapps.application.AppContext;
import com.example.hnino.biblioapps.greendao.App;
import com.example.hnino.biblioapps.greendao.AppDao;
import com.example.hnino.biblioapps.greendao.Category;
import com.example.hnino.biblioapps.greendao.DaoSession;
import com.example.hnino.biblioapps.greendao.Image;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hnino on 25/04/2016.
 */
public class SyncBusiness {

    private DaoSession mDaoSession;
    private Context mContext;

    private static final String SQL_DISTINCT_ENAME = "SELECT DISTINCT "+ AppDao.Properties.Category.columnName+" FROM "+AppDao.TABLENAME;

    public SyncBusiness(Context mContext) {
        this.mContext = mContext;
        mDaoSession = ((AppContext)mContext).getDaoSession();
    }

    public long insertCategory(Category db){

        return mDaoSession.getCategoryDao().insert(db);
    }



    public long insertApp(App db){

        return mDaoSession.getAppDao().insert(db);
    }

    public void insertImage(Image db){

        mDaoSession.getImageDao().insert(db);
    }
    public boolean thereAreRegistersInDatabase(){
        boolean response = mDaoSession.getAppDao().count() == 0 ||
                mDaoSession.getCategoryDao().count() == 0 ||
                mDaoSession.getImageDao().count() == 0;
        return !response;
    }



    public  List<String> listCategories() {
        ArrayList<String> result = new ArrayList<String>();
        Cursor c = mDaoSession.getDatabase().rawQuery(SQL_DISTINCT_ENAME, null);
        try{
            if (c.moveToFirst()) {
                do {
                    result.add(c.getString(0));
                } while (c.moveToNext());
            }
        } finally {
            c.close();
        }
        return result;
    }

}
