package unicauca.movil.tubarberia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import unicauca.movil.tubarberia.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
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
        }

    }
    public void goToNext(){

        String usuario = binding.user.getText().toString();
        String password = binding.pass.getText().toString();

        if(!(usuario.isEmpty() && password.isEmpty())){
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
        }
    }

    public void goToRegist(){
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }
}
