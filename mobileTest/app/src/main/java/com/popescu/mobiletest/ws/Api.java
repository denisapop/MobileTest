package com.popescu.mobiletest.ws;

import com.popescu.mobiletest.model.Users;
import com.popescu.mobiletest.utils.Constants;
import com.popescu.mobiletest.utils.Utils;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by atnm-4 on 29/09/2017.
 */

public class Api {


    private static ApiInterface sApiService;

    public static ApiInterface getApiClient() {

        if (sApiService == null) {
            // create an adapter for retrofit with base url

            Retrofit restAdapter = new Retrofit.Builder()
                    .baseUrl(Constants.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(Utils.okClient())
                    .build();
            sApiService = restAdapter.create(ApiInterface.class);
        }

        return sApiService;
    }

    public interface ApiInterface {

        @GET(Constants.URL)
        Call<Users> getUsers(@Query("page") int page, @Query("results") int nr, @Query("seed") String seed);
    }

}
