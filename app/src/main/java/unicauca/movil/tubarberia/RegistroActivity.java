package unicauca.movil.tubarberia;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import unicauca.movil.tubarberia.databinding.ActivityRegistroBinding;

public class RegistroActivity extends AppCompatActivity {

    ActivityRegistroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registro);
        binding.setRegist(this);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/brush.TTF");
        binding.titleRegist.setTypeface(typeface);

    }

}
