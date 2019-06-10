package org.mazz.restrowaiter.Event;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import org.mazz.restrowaiter.Data.RestApiData;
import org.mazz.restrowaiter.Modal.PosModal;

public class TableEvent {

public static void posSpinnerItemClick(final Context context, Spinner posSpinner, final GridView gridView) {

    posSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> adapter, View v,
                                   int position, long id) {
            // On selecting a spinner item
            PosModal item = (PosModal) adapter.getItemAtPosition(position);

            RestApiData.setTableData(context,gridView,item.getPosCode());
            // Showing selected spinner item
//            Toast.makeText(context, "Selected  : " + item.getPosCode(),
//                    Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }
    });
}

}
