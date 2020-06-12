package com.permana.football.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
    private static final String baseURl = "http://192.168.43.254/alba/";
    private static Retrofit retro;

    public static Retrofit konekRetrofit(){
        if (retro == null) {
            retro = new Retrofit.Builder()
                    .baseUrl(baseURl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }

}
