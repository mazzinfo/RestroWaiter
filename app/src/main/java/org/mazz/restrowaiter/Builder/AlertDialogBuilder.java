package org.mazz.restrowaiter.Builder;

import android.app.AlertDialog;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.mazz.restrowaiter.Adapter.WaiterSpinnerAdapter;
import org.mazz.restrowaiter.Data.RestApiData;
import org.mazz.restrowaiter.Event.TableEvent;
import org.mazz.restrowaiter.Modal.TableModal;
import org.mazz.restrowaiter.Modal.WaiterModal;
import org.mazz.restrowaiter.R;
import org.mazz.restrowaiter.TableActivity;

public class AlertDialogBuilder {


    public static void openPaxDialog(Context context, ViewGroup viewGroup, TableModal tableModal) {

        //then we will inflate the custom alert dialog xml that we created
        View dialogView = LayoutInflater.from(context).inflate(R.layout.table_pax_dialog, viewGroup, false);
        Spinner waiterSpinner = (Spinner) dialogView.findViewById(R.id.waiter_spinner);
        Button paxOkButton=(Button) dialogView.findViewById(R.id.btn_pax_ok);
        Button paxCancelButton=(Button) dialogView.findViewById(R.id.btn_pax_cancel);
        EditText paxCountEt=dialogView.findViewById(R.id.et_pax_count);



        RestApiData.setWaiterData(context,waiterSpinner);

        TableEvent.waiterSpinnerItemClick(context,waiterSpinner);
        //Now we need an AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

//setting the view of the builder to our custom view that we already inflated
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

//        TableEvent.paxCountChanged(context,paxCountEt);


        TableEvent.updatePaxOkButtonEvent(context,paxOkButton,tableModal,paxCountEt,waiterSpinner,alertDialog );
        TableEvent.paxCancelButtonEvent(context,paxCancelButton,alertDialog);

//finally creating the alert dialog and displaying it
    }}