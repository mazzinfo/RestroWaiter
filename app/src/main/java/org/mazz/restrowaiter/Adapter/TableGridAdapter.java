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
//    private final String[] string;
//    private final int[] Imageid;
    ArrayList<TableModal> list;

    public TableGridAdapter(Context c, ArrayList<TableModal> objects ) {
        mContext = c;
        this.list = objects;
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

    @Override
    public Object getItem(int p) {
        return null;
    }

    @Override
    public long getItemId(int p) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.table_grid_view_layout, null);
            final  TextView person_count = (TextView) grid.findViewById(R.id.tv_person_count);
            final  TextView time_count = (TextView) grid.findViewById(R.id.tv_time_count);

            final  TextView table_name = (TextView) grid.findViewById(R.id.tv_table_name);
            final  TextView salesperson_name = (TextView) grid.findViewById(R.id.tv_salesperson_name);
            final  TextView amount = (TextView) grid.findViewById(R.id.tv_amount);

            TableRow layouHeader = (TableRow)grid.findViewById(R.id.row_header);

            TableRow layoutFooter = (TableRow)grid.findViewById(R.id.row_footer);


//            ImageView imageView = (ImageView)grid.findViewById(R.id.img_person_count);
            final TableModal tableData = list.get(position);

                if(tableData.getTableStatus()==1){
                layouHeader.setBackgroundColor(mContext.getResources().getColor(R.color.occupied));
                layoutFooter.setBackgroundColor(mContext.getResources().getColor(R.color.occupied));
            }if(tableData.getTableStatus()==0){
                layouHeader.setBackgroundColor(mContext.getResources().getColor(R.color.vacant));
                layoutFooter.setBackgroundColor(mContext.getResources().getColor(R.color.vacant));
            }else{

            }

            person_count.setText(""+tableData.getPax());
            time_count.setText(""+tableData.getSitHour()+":"+tableData.getSitMin());
            table_name.setText(""+tableData.getTableNo());
            if(tableData.getWaiterName()!= null && tableData.getWaiterName().length()>0){
                salesperson_name.setText(""+tableData.getWaiterName());
            }else{
                salesperson_name.setText("");
            }

            amount.setText(NumberUtil.convertCurreny(""+tableData.getTotalAmount(),"INR"));


//            textView.setText(string[p]);
//            imageView.setImageResource(Imageid[p]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
