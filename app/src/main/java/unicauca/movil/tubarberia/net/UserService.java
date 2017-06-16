package unicauca.movil.tubarberia.net;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import unicauca.movil.tubarberia.models.SimpleResponse;
import unicauca.movil.tubarberia.models.User;



public interface UserService {

    @POST("users/login")
    Call<SimpleResponse> login (@Body User user);

    @POST("users/registro")
    Call<SimpleResponse> registro (@Body User user);

}
