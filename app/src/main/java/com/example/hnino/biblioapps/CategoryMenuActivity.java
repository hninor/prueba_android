package com.example.hnino.biblioapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hnino.biblioapps.business.CategoryBusiness;
import com.example.hnino.biblioapps.business.SyncBusiness;
import com.example.hnino.biblioapps.task.UpdateMastersTask;
import com.example.hnino.biblioapps.util.Constant;

import java.util.List;

public class CategoryMenuActivity extends AppCompatActivity {

    private CategoryBusiness categoryBusiness;
    private SyncBusiness syncBusiness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_menu);
        syncBusiness = new SyncBusiness(getApplicationContext());
        categoryBusiness = new CategoryBusiness(getApplicationContext());
        if (syncBusiness.thereAreRegistersInDatabase()) {
            initialConfiguration();
        } else {
            new UpdateMastersTask(this).execute();
        }

    }

    public void initialConfiguration(){
        final List<String> list = categoryBusiness.getItemNames();
        ListView listView = (ListView) findViewById(R.id.lvCategories);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_customize, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                Intent intent = new Intent(CategoryMenuActivity.this, AppMenuActivity.class);
                intent.putExtra(Constant.CATEGORY, (String) parent.getItemAtPosition(position));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }

        });
    }
}
