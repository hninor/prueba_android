package com.example.hnino.biblioapps.mapper;

import android.content.Context;

import com.example.hnino.biblioapps.business.SyncBusiness;
import com.example.hnino.biblioapps.greendao.App;
import com.example.hnino.biblioapps.greendao.Category;
import com.example.hnino.biblioapps.greendao.Image;
import com.example.hnino.biblioapps.rest.model.beans.Entry;
import com.example.hnino.biblioapps.rest.model.beans.ImImage;
import com.example.hnino.biblioapps.rest.model.beans.InformationResult;

import java.util.List;


/**
 * Created by hnino on 25/04/2016.
 */
public class RestMapper {

    //fields
    private Context mContext;
    private SyncBusiness mSyncBusiness;

    //Constructor

    public RestMapper(Context mContext) {
        this.mContext = mContext;
        this.mSyncBusiness = new SyncBusiness(mContext);
    }

    //methods

    //************************************Mapeando información a base de datos***************************
    public void informationResultComToDb(InformationResult informationResult){
        List<Entry> appList = informationResult.getFeed().getEntry();
        for(Entry entry : appList){
            entryComToDb(entry);
        }

        List<String> categoryList = mSyncBusiness.listCategories();
        for(String title : categoryList){
            Category category = new Category();
            category.setTitle(title);
            mSyncBusiness.insertCategory(category);
        }
    }

    public void entryComToDb(Entry entry){
        App app = new App();
        app.setName(entry.getImName().getLabel());
        app.setCategory(entry.getCategory().getAttributes().getLabel());
        long index = mSyncBusiness.insertApp(app);
        for(ImImage imImage : entry.getImImage()){
            imageComToDb(imImage, index);
        }
    }

    public void imageComToDb(ImImage imImage, long idApp){
        Image image = new Image();
        int height;
        image.setUrl(imImage.getLabel());
        try {
            height = Integer.parseInt(imImage.getAttributes().getHeight());
        } catch (NumberFormatException e) {
            height = 100;
        }
        image.setHeight(height);
        image.setAppId(idApp);
        mSyncBusiness.insertImage(image);
    }



}
