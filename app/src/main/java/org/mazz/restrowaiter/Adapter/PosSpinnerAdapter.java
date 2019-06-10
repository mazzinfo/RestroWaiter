package org.mazz.restrowaiter.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.mazz.restrowaiter.Modal.PosModal;
import org.mazz.restrowaiter.R;

import java.util.ArrayList;

public class PosSpinnerAdapter extends ArrayAdapter<PosModal> {

    private Context context1;
    private ArrayList<PosModal> data;
    public Resources res;
    LayoutInflater inflater;

    public PosSpinnerAdapter(Context context, ArrayList<PosModal> objects) {
        super(context, R.layout.pos_spinner_row, objects);

        context1 = context;
        data = objects;

        inflater = (LayoutInflater) context1
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public PosModal getItem(int position) {
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

    // This funtion called for each row ( Called data.size() times )
    public View getCustomView(int position, View convertView, ViewGroup parent) {

        View row = inflater.inflate(R.layout.pos_spinner_row, parent, false);

        final PosModal posData = data.get(position);

        TextView tvCategory = (TextView) row.findViewById(R.id.tvCategory);

        tvCategory.setText(posData.getPosName());

        return row;
    }
}

