package com.example.hnino.biblioapps.task;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.hnino.biblioapps.CategoryMenuActivity;
import com.example.hnino.biblioapps.R;
import com.example.hnino.biblioapps.mapper.SyncManager;

import java.util.concurrent.ExecutionException;

/**
 * Created by hnino on 21/08/2016.
 */
public class UpdateMastersTask extends AsyncTask<Void, Void, Void> {

    private ProgressDialog mProgressDialog;
    private Activity mActivity;
    private SyncManager mSyncManager;
    private String message;

    @Override
    protected void onPreExecute() {
        //mProgressDialog.setTitle(mActivity.getString(R.string.progress_dialog_update_master_title));
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.setIcon(R.mipmap.ic_launcher);
        mProgressDialog.setMessage(mActivity.getString(R.string.progress_dialog_update_master_title));
        mProgressDialog.show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (mProgressDialog.isShowing()) mProgressDialog.dismiss();
        if (message == null) {
            ((CategoryMenuActivity) mActivity).initialConfiguration();
            //Toast.makeText(mActivity, mActivity.getString(R.string.alert_master_data_updated), Toast.LENGTH_SHORT).show();
        } else {
            AlertDialog.Builder alert = new AlertDialog.Builder(mActivity);
            alert.setMessage(mActivity.getString(R.string.progress_dialog_update_master_error_updating_data) + " " + message);
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }
            });
            alert.show();
        }
    }

    @Override
    protected Void doInBackground(Void... params) {

        try {
            mSyncManager.syncAll();
        } catch (InterruptedException e) {
            message = e.getMessage();
        } catch (ExecutionException e) {
            message = e.getMessage();
        }
        return null;
    }

    //Constructor
    public UpdateMastersTask(Activity activity) {
        this.mActivity = activity;
        this.mProgressDialog = new ProgressDialog(activity);
        this.mSyncManager = new SyncManager(activity.getApplicationContext());
    }
}
