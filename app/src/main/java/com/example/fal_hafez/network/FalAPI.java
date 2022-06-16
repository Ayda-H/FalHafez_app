package com.example.fal_hafez.network;
import com.example.fal_hafez.model.Faal;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FalAPI {

    String BASE_URL = "https://ganjgah.ir/api/ganjoor/hafez/";

    @GET("faal")
    Call<Faal> getFal();

}
