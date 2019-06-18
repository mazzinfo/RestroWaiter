package org.mazz.restrowaiter.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TableRow;
import android.widget.TextView;

import org.mazz.restrowaiter.R;
import org.mazz.restrowaiter.Modal.TableModal;
import org.mazz.restrowaiter.Util.NumberUtil;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TableGridAdapter extends BaseAdapter {
    private Context mContext;
    ArrayList<TableModal> list;

    LayoutInflater inflater ;

    public TableGridAdapter(Context c, ArrayList<TableModal> objects ) {
        mContext = c;
        this.list = objects;
        inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        this.Imageid = Imageid;
//        this.string = string;
    }

    @Override
    public int getCount() {
        if(list.size() == 0){
            return 0;
        }else{
            return list.size();
        }
    }

    public TableModal getItem(int position) {
        return list.get(position);
    }


    @Override
    public long getItemId(int p) {
        return 0;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.table_grid_view_layout, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }

        final ViewHolder holder = (ViewHolder) convertView.getTag();

        final TableModal tableData = list.get(position);

        if(tableData.getTableStatus()==1){
            holder.layouHeader.setBackgroundColor(mContext.getResources().getColor(R.color.occupied));
            holder.layoutFooter.setBackgroundColor(mContext.getResources().getColor(R.color.occupied));
        }if(tableData.getTableStatus()==0) {
            holder.layouHeader.setBackgroundColor(mContext.getResources().getColor(R.color.vacant));
            holder.layoutFooter.setBackgroundColor(mContext.getResources().getColor(R.color.vacant));
        }
        holder.person_count.setText(""+tableData.getPax());
        holder.time_count.setText(""+tableData.getSitHour()+":"+tableData.getSitMin());
        holder.table_name.setText(""+tableData.getTableNo());
        if(tableData.getWaiterName()!= null && tableData.getWaiterName().length()>0){
            holder. salesperson_name.setText(""+tableData.getWaiterName());
        }else{
            holder.salesperson_name.setText("");
        }

        holder.amount.setText(NumberUtil.convertCurreny(""+tableData.getTotalAmount(),"INR"));

        return convertView;
    }

    static class ViewHolder {
        TextView person_count,time_count,table_name,salesperson_name,amount;
        TableRow layouHeader,layoutFooter;

        ViewHolder(View root) {
            person_count = (TextView) root.findViewById(R.id.tv_person_count);
            time_count = (TextView) root.findViewById(R.id.tv_time_count);
            table_name = (TextView) root.findViewById(R.id.tv_table_name);
            salesperson_name = (TextView) root.findViewById(R.id.tv_salesperson_name);
            amount = (TextView) root.findViewById(R.id.tv_amount);

             layouHeader = (TableRow)root.findViewById(R.id.row_header);

             layoutFooter = (TableRow)root.findViewById(R.id.row_footer);

        }
    }
}
