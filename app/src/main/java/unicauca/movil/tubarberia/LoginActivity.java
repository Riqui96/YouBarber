package unicauca.movil.tubarberia;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import unicauca.movil.tubarberia.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.setLogin(this);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/brush.TTF");
        binding.title.setTypeface(typeface);

    }
    public void goToNext(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToRegist(){
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }
}
