package com.example.hnino.biblioapps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hnino.biblioapps.business.CategoryBusiness;
import com.example.hnino.biblioapps.business.SyncBusiness;
import com.example.hnino.biblioapps.task.UpdateMastersTask;

import java.util.List;

public class CategoryMenuActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_menu);
        SyncBusiness syncBusiness = new SyncBusiness(getApplicationContext());
        CategoryBusiness categoryBusiness = new CategoryBusiness(getApplicationContext());
        if (syncBusiness.thereAreRegistersInDatabase()) {
            //DO NOTHING
        } else {
            new UpdateMastersTask(this).execute();
        }
        final List<String> list = categoryBusiness.getItemNames();
        ListView listView = (ListView) findViewById(R.id.lvCategories);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                list.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        });
    }
}
