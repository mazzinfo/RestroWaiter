package org.mazz.restrowaiter.Service;

import org.mazz.restrowaiter.Modal.KotDetailsModal;
import org.mazz.restrowaiter.Modal.PosModal;
import org.mazz.restrowaiter.Modal.TableModal;
import org.mazz.restrowaiter.Modal.WaiterModal;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RestApiService {


    @GET("api/tableWithWaiterList/{posId}")
    public Call<List<TableModal>> getTableList(@Path("posId") int posCode);

    @GET("api/posMasterList")
    public Call<List<PosModal>> getPosList();

    @GET("api/waiterMasterList")
    public Call<List<WaiterModal>> getWaiterList();

    @PUT("api/updateTableStatus/{tableId}")
    public Call<ResponseBody> UpdateTableStatus(@Path("tableId") int tableId,@Body TableModal tableModal);


    @GET("api/kotDetailListByTable/{unqNo}")
    public Call<List<KotDetailsModal>> getKotDetailsByTable(@Path("unqNo") int unqNo);
}
