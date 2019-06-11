package org.mazz.restrowaiter.Event;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import org.mazz.restrowaiter.Adapter.WaiterSpinnerAdapter;
import org.mazz.restrowaiter.Builder.AlertDialogBuilder;
import org.mazz.restrowaiter.Data.RestApiData;
import org.mazz.restrowaiter.KotActivity;
import org.mazz.restrowaiter.Modal.PosModal;
import org.mazz.restrowaiter.Modal.TableModal;
import org.mazz.restrowaiter.Modal.WaiterModal;
import org.mazz.restrowaiter.Session.TableSession;
import org.mazz.restrowaiter.TableActivity;
import org.mazz.restrowaiter.Util.DateUtil;

public class TableEvent {

public static void posSpinnerItemClick(final Context context, Spinner posSpinner, final GridView gridView) {

    posSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> adapter, View v,
                                   int position, long id) {
            // On selecting a spinner item
            PosModal item = (PosModal) adapter.getItemAtPosition(position);

            RestApiData.setTableData(context,gridView,item.getPosCode());

        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }
    });
}


    public static void waiterSpinnerItemClick(final Context context, Spinner waiterSpinner) {

        waiterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                WaiterModal item = (WaiterModal) adapter.getItemAtPosition(position);
                TableSession tableSession = new TableSession(context);

                tableSession.createWaiter(item.getWaiterCode(),item.getWaiterName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }




    public static void updatePaxOkButtonEvent(final Context context, Button paxOkButton, final TableModal tableModal, final int paxCount) {

        paxOkButton.setOnClickListener(new View.OnClickListener() {
            TableSession tableSession=new TableSession(context);

            public void onClick(View v) {

                tableModal.setPax(paxCount);
                tableModal.setWaiterNo(510);
                tableModal.setSit(DateUtil.getCurrentTime());
                tableModal.setTableStatus(1);
                RestApiData.updateTableStatus(context,tableModal);
//
                // TODO Auto-generated method stub
                Toast.makeText(context, "pax click : ",
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    public static void tableItemClick(final Context context, GridView gridView, final ViewGroup paxDialog) {

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TableModal item = (TableModal) parent.getItemAtPosition(position);



    if(item.getTableStatus()==0) {
        AlertDialogBuilder.openPaxDialog(context,paxDialog,item);


    Toast.makeText(context, "Selected  : " + item.getTableNo(),
            Toast.LENGTH_LONG).show();
    }if (item.getTableStatus()==1){
                    Intent myIntent = new Intent(context, KotActivity.class);
                    context.startActivity(myIntent);

                }


            }


        });
    }

}
