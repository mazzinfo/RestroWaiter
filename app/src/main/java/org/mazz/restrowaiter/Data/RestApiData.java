package org.mazz.restrowaiter.Data;

import android.content.Context;
import android.util.Log;
import android.widget.GridView;
import android.widget.Spinner;

import org.mazz.restrowaiter.Adapter.PosSpinnerAdapter;
import org.mazz.restrowaiter.Adapter.TableGridAdapter;
import org.mazz.restrowaiter.Adapter.WaiterSpinnerAdapter;
import org.mazz.restrowaiter.Modal.PosModal;
import org.mazz.restrowaiter.Modal.TableModal;
import org.mazz.restrowaiter.Modal.WaiterModal;
import org.mazz.restrowaiter.TableActivity;
import org.mazz.restrowaiter.Util.RestApiUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestApiData {

    public static void setTableData(final Context context, final GridView tableGridView,int posCode) {
        //noinspection NullableProblems
        RestApiUtil.getServiceClass().getTableList(posCode).enqueue(new Callback<List<TableModal>>() {

            @Override
            public void onResponse(Call<List<TableModal>> call, Response<List<TableModal>> response) {
                if (response.isSuccessful()) {
                    ArrayList<TableModal> postList = (ArrayList<TableModal>) response.body();
                    Log.d("Result", "Returned count " + Objects.requireNonNull(postList).get(0).getTableNo());
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


              final ArrayList<PosModal> postList=new ArrayList<PosModal>();



            @Override
            public void onResponse(Call<List<PosModal>> call, Response<List<PosModal>> response) {
                if (response.isSuccessful()) {
                    ArrayList<PosModal> postList1=new ArrayList<PosModal>();
                    postList1.add(new PosModal(0,"All"));
                    postList.addAll(postList1);
                    ArrayList<PosModal> postList2;

                    postList2 = (ArrayList<PosModal>) response.body();
                    postList.addAll(Objects.requireNonNull(postList2));
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



    public static void setWaiterData(final Context context, final Spinner waiterSpinner) {

        RestApiUtil.getServiceClass().getWaiterList().enqueue(new Callback<List<WaiterModal>>() {


            ArrayList<WaiterModal> postList=new ArrayList<WaiterModal>();



            @Override
            public void onResponse(Call<List<WaiterModal>> call, Response<List<WaiterModal>> response) {
                if (response.isSuccessful()) {
                    postList = (ArrayList<WaiterModal>) response.body();
                    Log.d("Result", "Returned count " + Objects.requireNonNull(postList).size());
                    waiterSpinner.setAdapter(new WaiterSpinnerAdapter(context, postList));
                }
            }
            @Override
            public void onFailure(Call<List<WaiterModal>> call, Throwable t) {
                Log.d("Error", "error loading from API" + t.getMessage());
            }

        });
    }

    public static void updateTableStatus(final Context context, final TableModal tableModal) {

        RestApiUtil.getServiceClass().UpdateTableStatus(tableModal.getUnqNo(),tableModal).enqueue(new Callback<ResponseBody>() {






            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("Success", "waiter from API" + response.body());
                if (response.isSuccessful()) {



//
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //showErrorMessage();
                Log.d("Error", "error loading from API" + t.getMessage());
            }

        });
    }






}
