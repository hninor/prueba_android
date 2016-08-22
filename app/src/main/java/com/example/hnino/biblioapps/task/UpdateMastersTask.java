package com.example.hnino.biblioapps.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

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

    @Override
    protected void onPreExecute() {
        mProgressDialog.setTitle(mActivity.getString(R.string.progress_dialog_update_master_title));
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (mProgressDialog.isShowing()) mProgressDialog.dismiss();
/*        if (message.isEmpty())
            Toast.makeText(act, act.getString(R.string.alert_master_data_updated), Toast.LENGTH_SHORT).show();
        else {
            AlertDialog.Builder alert = new AlertDialog.Builder(act);
            alert.setMessage(act.getString(R.string.progress_dialog_update_master_error_updating_data) + " " + message);
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }
            });
            alert.show();
        }*/
    }

    @Override
    protected Void doInBackground(Void... params) {

        try {
            mSyncManager.syncAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
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
