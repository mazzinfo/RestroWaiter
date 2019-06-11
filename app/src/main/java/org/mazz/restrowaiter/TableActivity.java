package org.mazz.restrowaiter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.mazz.restrowaiter.Adapter.PosSpinnerAdapter;
import org.mazz.restrowaiter.Adapter.TableGridAdapter;
import org.mazz.restrowaiter.Data.RestApiData;
import org.mazz.restrowaiter.Event.TableEvent;
import org.mazz.restrowaiter.Modal.PosModal;
import org.mazz.restrowaiter.Util.RestApiUtil;
import org.mazz.restrowaiter.Modal.TableModal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TableActivity extends AppCompatActivity {
    private TextView mTextMessage;

    GridView gridView;
    private Spinner pos_spinner;
    ViewGroup viewGroup;




    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.app_name);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.login);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.server_connection);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_table);

        Toolbar toolbar = (Toolbar) findViewById(R.id.table_toolbar);
        pos_spinner = (Spinner) findViewById(R.id.pos_spinner);
        //setting the title
        toolbar.setTitle("My Toolbar");

        //placing toolbar in place of actionbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

         viewGroup = findViewById(android.R.id.content);

        gridView = (GridView) findViewById(R.id.table_grid);


//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        mTextMessage = findViewById(R.id.message);
//        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



      //  RestApiData.setTableData(this,gridView);

       RestApiData.setPosData(this,pos_spinner);

        TableEvent.posSpinnerItemClick(this,pos_spinner,gridView);
        TableEvent.tableItemClick(this,gridView,viewGroup);

//        gridView.setAdapter(new TableGridAdapter(this, gridViewStrings, gridViewImages));
       // addItemsToSpinner();
    }





//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.pos_spinner_menu, menu);
//
//        MenuItem item = menu.findItem(R.id.pos_spinner_layout_menu);
//        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);
//
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.spinner_list_item_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        spinner.setAdapter(adapter);
//        return true;
//    }
@Override
protected void onStart()
{
    // TODO Auto-generated method stub
    super.onStart();

//    RestApiData.setTableData(this,gridView,0);
}


    @Override
    protected void onResume()
    {
        // TODO Auto-generated method stub

        RestApiData.setTableData(this,gridView,0);
        super.onResume();
    }


}
