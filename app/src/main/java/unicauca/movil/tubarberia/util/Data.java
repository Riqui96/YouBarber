package unicauca.movil.tubarberia.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Data {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.56.1:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
