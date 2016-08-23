package com.example.hnino.biblioapps.business;

import android.content.Context;

import com.example.hnino.biblioapps.application.AppContext;
import com.example.hnino.biblioapps.greendao.App;
import com.example.hnino.biblioapps.greendao.AppDao;
import com.example.hnino.biblioapps.greendao.DaoSession;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;


/**
 * Created by hnino on 25/04/2016.
 */
public class AppBusiness {

    private DaoSession mDaoSession;
    private Context mContext;


    public AppBusiness(Context mContext) {
        this.mContext = mContext;
        mDaoSession = ((AppContext)mContext).getDaoSession();
    }



    public List<App> getAppsByCategory(String categoryName){
        QueryBuilder<App> qb = mDaoSession.getAppDao().queryBuilder();
        return  qb.where(AppDao.Properties.Category.eq(categoryName)).list();
    }

    public App getAppById(long key){
        return mDaoSession.getAppDao().load(key);
    }

}
