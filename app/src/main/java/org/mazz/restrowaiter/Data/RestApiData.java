package org.mazz.restrowaiter.Data;

import android.content.Context;
import android.util.Log;
import android.widget.GridView;
import android.widget.Spinner;

import org.mazz.restrowaiter.Adapter.PosSpinnerAdapter;
import org.mazz.restrowaiter.Adapter.TableGridAdapter;
import org.mazz.restrowaiter.Modal.PosModal;
import org.mazz.restrowaiter.Modal.TableModal;
import org.mazz.restrowaiter.TableActivity;
import org.mazz.restrowaiter.Util.RestApiUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestApiData {

    public static void setTableData(final Context context, final GridView tableGridView,int posCode) {
        RestApiUtil.getServiceClass().getTableList(posCode).enqueue(new Callback<List<TableModal>>() {

            @Override
            public void onResponse(Call<List<TableModal>> call, Response<List<TableModal>> response) {
                if (response.isSuccessful()) {
                    ArrayList<TableModal> postList = (ArrayList<TableModal>) response.body();
                    Log.d("Result", "Returned count " + postList.get(0).getTableNo());
                    System.out.println("\"Returned count \" + postList.size()");

                    tableGridView.setAdapter(new TableGridAdapter(context, postList));
//
                }
            }

            @Override
            public void onFailure(Call<List<TableModal>> call, Throwable t) {
                //showErrorMessage();
                Log.d("Error", "error loading from API" + t.getMessage());
            }

        });
    }



    public static void setPosData(final Context context, final Spinner posSpinner) {

        RestApiUtil.getServiceClass().getPosList().enqueue(new Callback<List<PosModal>>() {


              ArrayList<PosModal> postList=new ArrayList<PosModal>();



            @Override
            public void onResponse(Call<List<PosModal>> call, Response<List<PosModal>> response) {
                if (response.isSuccessful()) {
                    ArrayList<PosModal> postList1=new ArrayList<PosModal>();
                    postList1.add(new PosModal(0,"All"));
                    postList.addAll(postList1);
                    ArrayList<PosModal> postList2=new ArrayList<PosModal>();

                    postList2 = (ArrayList<PosModal>) response.body();
                    postList.addAll(postList2);
                    Log.d("Result", "Returned count " + postList.size());
                    System.out.println("\"Returned count \" + postList.size()");

                    posSpinner.setAdapter(new PosSpinnerAdapter(context, postList));


//
                }
            }

            @Override
            public void onFailure(Call<List<PosModal>> call, Throwable t) {
                //showErrorMessage();
                Log.d("Error", "error loading from API" + t.getMessage());
            }

        });
    }






}
