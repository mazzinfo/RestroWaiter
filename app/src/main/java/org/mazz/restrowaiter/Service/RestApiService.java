package org.mazz.restrowaiter.Service;

import org.mazz.restrowaiter.Modal.PosModal;
import org.mazz.restrowaiter.Modal.TableModal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApiService {


    @GET("api/tableWithWaiterList/{posId}")
    public Call<List<TableModal>> getTableList(@Path("posId") int posCode);

    @GET("api/posMasterList")
    public Call<List<PosModal>> getPosList();
}
