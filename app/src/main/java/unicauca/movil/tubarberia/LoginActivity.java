package unicauca.movil.tubarberia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unicauca.movil.tubarberia.databinding.ActivityLoginBinding;
import unicauca.movil.tubarberia.models.SimpleResponse;
import unicauca.movil.tubarberia.models.User;
import unicauca.movil.tubarberia.net.UserService;
import unicauca.movil.tubarberia.util.Data;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    UserService service;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.setLogin(this);

        //region font YouBarber
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/brush.TTF");
        binding.title.setTypeface(typeface);
        //endregion

        preferences = getSharedPreferences("preferencias", MODE_PRIVATE);
        boolean login = preferences.getBoolean("login",false);
        if(login){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        service = Data.retrofit.create(UserService.class);



    }

    public void goToRegist(){
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }

    public void goToNext(){

        final String mail = binding.user.getText().toString();
        String password = binding.pass.getText().toString();

        User user = new User(mail, password);

        final Call<SimpleResponse> request = service.login(user);
        request.enqueue(new Callback<SimpleResponse>() {
            @Override
            public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
                if(response.isSuccessful()){
                    SimpleResponse res = response.body();
                    if(res.isSucsess()){

                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean("login", true);
                        editor.putString("email", mail);
                        editor.apply();

                         Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                         startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, res.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<SimpleResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error al conectarse", Toast.LENGTH_SHORT).show();
            }
        });

        /*if(!(usuario.isEmpty() && password.isEmpty())){
            if(usuario.equals("Riqui") && password.equals("123")){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

                SharedPreferences.Editor edit = preferences.edit();
                edit.putBoolean("login", true);
                edit.apply();
                finish();
            }
            else {
                Toast.makeText(getApplicationContext(), "usuario o password incorrecto", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Debes introducir todos los datos. ", Toast.LENGTH_SHORT).show();
        }*/
    }


}
