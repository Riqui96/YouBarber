package unicauca.movil.tubarberia;


import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unicauca.movil.tubarberia.databinding.ActivityRegistroBinding;
import unicauca.movil.tubarberia.models.SimpleResponse;
import unicauca.movil.tubarberia.models.User;
import unicauca.movil.tubarberia.net.UserService;
import unicauca.movil.tubarberia.util.Data;

public class RegistroActivity extends AppCompatActivity implements Callback<SimpleResponse> {

    ActivityRegistroBinding binding;
    UserService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registro);
        binding.setRegist(this);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/brush.TTF");
        binding.titleRegist.setTypeface(typeface);

        service = Data.retrofit.create(UserService.class);

    }

    public void register(){
        String email = binding.inputEmail.getText().toString();
        String pass = binding.inputPassword.getText().toString();
        String name = binding.inputName.getText().toString();

        User user = new User(name,email,pass);
        Call<SimpleResponse> request = service.registro(user);
        request.enqueue(this);

    }

    @Override
    public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
        if(response.isSuccessful()){
            SimpleResponse res = response.body();
            if(res.isSucsess()){
                Toast.makeText(this, "Registro Exitoso !", Toast.LENGTH_SHORT).show();
                finish();
            }else {
                Toast.makeText(RegistroActivity.this, res.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onFailure(Call<SimpleResponse> call, Throwable t) {
        Toast.makeText(RegistroActivity.this, "Error al conectarse", Toast.LENGTH_SHORT).show();
    }
}
