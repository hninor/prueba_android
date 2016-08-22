package com.example.hnino.biblioapps.business;

import android.content.Context;

import com.example.hnino.biblioapps.application.AppContext;
import com.example.hnino.biblioapps.greendao.Category;
import com.example.hnino.biblioapps.greendao.DaoSession;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hnino on 25/04/2016.
 */
public class CategoryBusiness {

    private DaoSession mDaoSession;
    private Context mContext;


    public CategoryBusiness(Context mContext) {
        this.mContext = mContext;
        mDaoSession = ((AppContext)mContext).getDaoSession();
    }

    public List<Category> getItems() {
        return mDaoSession.getCategoryDao().loadAll();
    }

    public List<String> getItemNames(){
        List<Category> categoryList = mDaoSession.getCategoryDao().loadAll();
        List<String> result = new ArrayList<>();
        for(Category materialDB : categoryList){
            result.add(materialDB.getTitle());
        }
        return result;
    }

}
