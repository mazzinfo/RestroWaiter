package org.mazz.restrowaiter.Data;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.mazz.restrowaiter.Adapter.KotListAdapter;
import org.mazz.restrowaiter.Adapter.PosSpinnerAdapter;
import org.mazz.restrowaiter.Adapter.TableGridAdapter;
import org.mazz.restrowaiter.Adapter.WaiterSpinnerAdapter;
import org.mazz.restrowaiter.KotActivity;
import org.mazz.restrowaiter.Modal.KotDetailsModal;
import org.mazz.restrowaiter.Modal.PosModal;
import org.mazz.restrowaiter.Modal.TableModal;
import org.mazz.restrowaiter.Modal.WaiterModal;
import org.mazz.restrowaiter.TableActivity;
import org.mazz.restrowaiter.Util.NumberUtil;
import org.mazz.restrowaiter.Util.RestApiUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestApiData {

    public static void setTableData(final Context context, final GridView tableGridView, int posCode) {
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


            final ArrayList<PosModal> postList = new ArrayList<PosModal>();


            @Override
            public void onResponse(Call<List<PosModal>> call, Response<List<PosModal>> response) {
                if (response.isSuccessful()) {
                    ArrayList<PosModal> postList1 = new ArrayList<PosModal>();
                    postList1.add(new PosModal(0, "All"));
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


            ArrayList<WaiterModal> postList = new ArrayList<WaiterModal>();


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

    public static void updateTableStatus(final Context context, final TableModal tableModal,final AlertDialog paxAlertDialog) {

        RestApiUtil.getServiceClass().UpdateTableStatus(tableModal.getUnqNo(), tableModal).enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("Success", "waiter from API" + response.body());

                paxAlertDialog.cancel();
                Intent myIntent = new Intent(context, KotActivity.class);

                myIntent.putExtra("table_data", tableModal);
                context.startActivity(myIntent);
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


    public static void setKotData(final Context context, final ListView kotListView, int unqNo, final TextView kotQty,final TextView kotRate,final TextView kotGst,final TextView kotAmount) {
        //noinspection NullableProblems
        RestApiUtil.getServiceClass().getKotDetailsByTable(unqNo).enqueue(new Callback<List<KotDetailsModal>>() {
            ArrayList<KotDetailsModal> kotList=null;
            @Override
            public void onResponse(Call<List<KotDetailsModal>> call, Response<List<KotDetailsModal>> response) {
                if (response.isSuccessful()) {

                    kotList = (ArrayList<KotDetailsModal>) response.body();

                    BigDecimal kotQtyTotal=new BigDecimal(0);
                    BigDecimal kotRateTotal=new BigDecimal(0);
                    BigDecimal kotGstTotal=new BigDecimal(0);
                    BigDecimal kotAmountTotal=new BigDecimal(0);


                    if( kotList != null && !kotList.isEmpty()) {
                        Log.d("Result", "Returned count " + Objects.requireNonNull(kotList).get(0).getItemName());
                        System.out.println("\"Returned count \" + postList.size()");

                        kotListView.setAdapter(new KotListAdapter(context, kotList));


                        for (KotDetailsModal kot: kotList) {
                            kotQtyTotal=kot.getQuantity().add(kotQtyTotal);
                            kotRateTotal=kot.getAmount().add(kotRateTotal);
                            kotGstTotal=kot.getTaxAmount().add(kotGstTotal);


                        }
                        kotQty.setText(""+ NumberUtil.removeDecimal(kotQtyTotal));
                        kotRate.setText(""+ NumberUtil.convertCurreny(""+kotRateTotal,"INR"));
                        kotGst.setText(""+ NumberUtil.convertCurreny(""+kotGstTotal,"INR"));
                        kotAmount.setText(""+ NumberUtil.convertCurrencyWithRoundOff(""+kotRateTotal.add(kotGstTotal),"INR"));


                    }else{
                        kotQty.setText(""+ NumberUtil.removeDecimal(kotQtyTotal));
                        kotRate.setText(""+ NumberUtil.convertCurreny(""+kotRateTotal,"INR"));
                        kotGst.setText(""+ NumberUtil.convertCurreny(""+kotGstTotal,"INR"));
                        kotAmount.setText(""+ NumberUtil.convertCurrencyWithRoundOff(""+kotRateTotal.add(kotGstTotal),"INR"));
                    }
//
                }
            }

            @Override
            public void onFailure(Call<List<KotDetailsModal>> call, Throwable t) {
                //showErrorMessage();
                Log.d("Error", "error loading from API" + t.getMessage());
            }

        });
    }



}
