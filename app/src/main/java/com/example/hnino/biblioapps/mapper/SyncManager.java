package com.example.hnino.biblioapps.mapper;

import android.content.Context;

import com.example.hnino.biblioapps.rest.controller.api.RestController;
import com.example.hnino.biblioapps.rest.controller.api.RestControllerFactory;
import com.example.hnino.biblioapps.rest.model.beans.InformationResult;
import com.magnet.android.mms.MagnetMobileClient;
import com.magnet.android.mms.async.Call;
import com.magnet.android.mms.exception.SchemaException;

import java.util.concurrent.ExecutionException;



public class SyncManager {

    private RestController mRestControllerGet;
    private Context mContext;
    private MagnetMobileClient mMagnetClient;


    public SyncManager(Context mContext)  {
        this.mContext = mContext;
        // Instantiate a controller
        mMagnetClient = MagnetMobileClient.getInstance(mContext);
        RestControllerFactory controllerFactory = new RestControllerFactory(mMagnetClient);
        try {
            mRestControllerGet = controllerFactory.obtainInstance();
        } catch (SchemaException e) {

        }

    }




    public void syncAll() throws InterruptedException, ExecutionException {
        Call<InformationResult> call = mRestControllerGet.getInformation(null);
        InformationResult resultado = call.get();

        if (resultado != null) {
            RestMapper restMapper = new RestMapper(mContext);
            restMapper.informationResultComToDb(resultado);
        }
    }



}
