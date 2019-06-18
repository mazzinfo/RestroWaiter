package org.mazz.restrowaiter.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import org.mazz.restrowaiter.Modal.KotDetailsModal;
import org.mazz.restrowaiter.Modal.PosModal;
import org.mazz.restrowaiter.R;
import org.mazz.restrowaiter.Util.NumberUtil;

import java.util.ArrayList;

public class KotListAdapter extends ArrayAdapter<KotDetailsModal> {


    private ArrayList<KotDetailsModal> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView tv_kot_item_name,tv_kot_rate,tv_kot_qty,tv_kot_amount,tv_kot_total_qty;
       ImageButton imb_kot_close;

    }

    public KotListAdapter(Context context,ArrayList<KotDetailsModal> data) {
        super(context, R.layout.kot_row_item, data);
        this.dataSet = data;
        this.mContext = context;

    }


    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        KotDetailsModal dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.kot_row_item, parent, false);
            viewHolder.tv_kot_item_name = (TextView) convertView.findViewById(R.id.tv_kot_item_name);
            viewHolder.imb_kot_close = (ImageButton) convertView.findViewById(R.id.imb_kot_close);
            viewHolder.tv_kot_rate = (TextView) convertView.findViewById(R.id.tv_kot_rate);
            viewHolder.tv_kot_qty = (TextView) convertView.findViewById(R.id.tv_kot_qty);
            viewHolder.tv_kot_amount = (TextView) convertView.findViewById(R.id.tv_kot_amount);


            result = convertView;

            convertView.setTag(viewHolder);




            LayoutInflater inflater1 = LayoutInflater.from(getContext());
           View convertView1 = inflater1.inflate(R.layout.activity_kot, parent, false);
            viewHolder.tv_kot_total_qty = (TextView) convertView1.findViewById(R.id.tv_kot_total_qty);


        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;
        viewHolder.tv_kot_total_qty.setText("Hello!");
        viewHolder.tv_kot_item_name.setText(""+dataModel.getItemName());
        viewHolder.tv_kot_rate.setText(""+NumberUtil.convertCurreny(""+dataModel.getRate(),"INR"));
        viewHolder.tv_kot_qty.setText(""+ NumberUtil.removeDecimal(dataModel.getQuantity()));
        viewHolder.tv_kot_amount.setText(""+NumberUtil.convertCurrencyWithRoundOff(""+dataModel.getAmount(),"INR"));
        return convertView;
    }
}