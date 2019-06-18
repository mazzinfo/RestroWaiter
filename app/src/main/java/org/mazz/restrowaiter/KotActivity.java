package org.mazz.restrowaiter;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.mazz.restrowaiter.Data.RestApiData;
import org.mazz.restrowaiter.Event.KotEvent;
import org.mazz.restrowaiter.Modal.TableModal;

public class KotActivity extends AppCompatActivity {

    ListView kotListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kot);
        Toolbar kotToolbar = (Toolbar) findViewById(R.id.kot_toolbar);
        TextView paxCount = (TextView) findViewById(R.id.tv_pax_data);
        kotListView=findViewById(R.id.kot_list);

        TextView tv_kot_total_qty = (TextView) findViewById(R.id.tv_kot_total_qty);

        TextView tv_kot_total_rate = (TextView) findViewById(R.id.tv_kot_total_rate);

        TextView tv_kot_total_gst = (TextView) findViewById(R.id.tv_kot_total_gst);

        TextView tv_kot_total_amount = (TextView) findViewById(R.id.tv_kot_total_amount);



        setSupportActionBar(kotToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

//        SearchView searchView = (SearchView) findViewById(R.id.sv_item);
//        int id = searchView.getContext()
//                .getResources()
//                .getIdentifier("android:id/search_src_text", null, null);
//        TextView textView = (TextView) searchView.findViewById(id);
//        textView.setTextColor(Color.WHITE);
//        textView.setHintTextColor(getResources().getColor(R.color.white));
        LinearLayout kotContenetLayout = (LinearLayout )findViewById(R.id.kot_content);



        Intent i = getIntent();
        TableModal tableData = (TableModal) i.getSerializableExtra("table_data");
        kotToolbar.setTitleTextColor(Color.WHITE);


        paxCount.setText("" + tableData.getPax());

        kotToolbar.setTitle("" + tableData.getTableNo());

        KotEvent.kotNavigation(this, kotToolbar);

        RestApiData.setKotData(this,kotListView,tableData.getUnqNo(),tv_kot_total_qty,tv_kot_total_rate,tv_kot_total_gst,tv_kot_total_amount);
        KotEvent.kotSearchNavigation(this,kotContenetLayout, tableData);

    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.kot_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_favorite) {
//            Toast.makeText(KotActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }*/
}
