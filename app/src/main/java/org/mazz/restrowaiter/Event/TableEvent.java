package org.mazz.restrowaiter.Event;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
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

    public static void paxCountChanged(final Context context,final EditText paxEditText) {

        paxEditText.addTextChangedListener(new TextWatcher() {

            // the user's changes are saved here
            public void onTextChanged(CharSequence c, int start, int before, int count) {

            }

            public void beforeTextChanged(CharSequence c, int start, int count, int after) {
                // this space intentionally left blank
            }

            public void afterTextChanged(Editable c) {
                // this one too
                paxEditText.setText(c.toString());
            }
        });
    }

    public static void updatePaxOkButtonEvent(final Context context, Button paxOkButton, final TableModal tableModal,final EditText paxEditText,
                                              final Spinner waiterSpinner,final AlertDialog paxAlertDialog) {

        paxOkButton.setOnClickListener(new View.OnClickListener() {
            TableSession tableSession=new TableSession(context);



            public void onClick(View v) {
                WaiterModal waiterModal = (WaiterModal) waiterSpinner.getSelectedItem();


                tableModal.setPax(Integer.parseInt(paxEditText.getText().toString()));
                tableModal.setWaiterNo((int) waiterModal.getWaiterNo());
                tableModal.setSit(DateUtil.getCurrentTime());
                tableModal.setTableStatus(1);
                RestApiData.updateTableStatus(context,tableModal,paxAlertDialog);
//
                // TODO Auto-generated method stub

            }
        });

    }

    public static void paxCancelButtonEvent(final Context context, Button paxOkButton,final AlertDialog paxAlertDialog) {

        paxOkButton.setOnClickListener(new View.OnClickListener() {
            TableSession tableSession=new TableSession(context);

            public void onClick(View v) {
                paxAlertDialog.cancel();


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


//    Toast.makeText(context, "Selected  : " + item.getTableNo(),
//            Toast.LENGTH_LONG).show();
    }if (item.getTableStatus()==1){
                    Intent myIntent = new Intent(context, KotActivity.class);

                    myIntent.putExtra("table_data",  item);
                    context.startActivity(myIntent);

                }


            }


        });
    }

}
