package org.mazz.restrowaiter.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.mazz.restrowaiter.Modal.PosModal;
import org.mazz.restrowaiter.Modal.WaiterModal;
import org.mazz.restrowaiter.R;

import java.util.ArrayList;

public class WaiterSpinnerAdapter extends ArrayAdapter<WaiterModal> {

    private Context context1;
    private ArrayList<WaiterModal> data;
    public Resources res;
    LayoutInflater inflater;

    public WaiterSpinnerAdapter(Context context, ArrayList<WaiterModal> objects) {
        super(context, R.layout.waiter_spinner_row, objects);

        context1 = context;
        data = objects;

        inflater = (LayoutInflater) context1
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public WaiterModal getItem(int position) {
        return data.get(position);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

   static WaiterModal waiterModal=null;
    public static void selectedWaiter(WaiterModal waiterModal){
        waiterModal=waiterModal;

    }

    public static WaiterModal getSelectedWaiter(){
        WaiterModal waiterModal2=waiterModal;
        return waiterModal2 ;
    }

    // This funtion called for each row ( Called data.size() times )
    public View getCustomView(int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.waiter_spinner_row, parent, false);

        final WaiterModal posData = data.get(position);

        TextView tvCategory = (TextView) row.findViewById(R.id.tv_waiter_name);

        tvCategory.setText(posData.getWaiterName());

        return row;
    }
}

