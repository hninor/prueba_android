package com.example.hnino.biblioapps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hnino.biblioapps.business.CategoryBusiness;
import com.example.hnino.biblioapps.business.SyncBusiness;
import com.example.hnino.biblioapps.task.UpdateMastersTask;
import com.example.hnino.biblioapps.util.Constant;

import java.util.List;

public class CategoryMenuActivity extends AppCompatActivity {

    //controles
    ListView lvCategories;
    //campos
    private CategoryBusiness categoryBusiness;
    private SyncBusiness syncBusiness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_menu);
        //Ajustes Action bar
        getSupportActionBar().setTitle(R.string.categories);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        //Incializando controles
        lvCategories = (ListView) findViewById(R.id.lvCategories);
        //Instanciando las clases de negocio
        syncBusiness = new SyncBusiness(getApplicationContext());
        categoryBusiness = new CategoryBusiness(getApplicationContext());
        if (syncBusiness.thereAreRegistersInDatabase()) {
            initialConfiguration();
        } else {
            new UpdateMastersTask(this).execute();
        }

    }

    /**
     * Si la consulta fue exitosa se llena el ListView con los datos capturados
     */
    public void initialConfiguration(){
        final List<String> list = categoryBusiness.getItemNames();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_customize, list);
        lvCategories.setAdapter(adapter);

        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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
