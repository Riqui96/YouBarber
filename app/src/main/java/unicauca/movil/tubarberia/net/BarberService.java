package unicauca.movil.tubarberia.net;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import unicauca.movil.tubarberia.models.Reserva;
import unicauca.movil.tubarberia.models.SimpleResponse;



public interface BarberService {

    @GET("barbers")
    Call<List<Reserva>> all();

    @POST("barbers")
    Call<SimpleResponse> insert(@Body Reserva reserva);
}
