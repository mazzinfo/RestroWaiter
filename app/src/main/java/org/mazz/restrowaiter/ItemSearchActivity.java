package org.mazz.restrowaiter;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import org.mazz.restrowaiter.Modal.TableModal;

public class ItemSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_search);

        Toolbar kotToolbar = (Toolbar) findViewById(R.id.item_search_toolbar);
        setSupportActionBar(kotToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        kotToolbar.setTitle("Item Search");
        kotToolbar.setTitleTextColor(Color.WHITE);
        Intent i = getIntent();
        TableModal tableData = (TableModal) i.getSerializableExtra("kot_table_data");
    }
}
