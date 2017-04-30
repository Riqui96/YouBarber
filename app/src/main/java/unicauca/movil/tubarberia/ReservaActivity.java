package unicauca.movil.tubarberia;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import unicauca.movil.tubarberia.databinding.ActivityReservaBinding;
import unicauca.movil.tubarberia.util.Info;

public class ReservaActivity extends AppCompatActivity {

    ActivityReservaBinding binding;
    int m=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reserva);

        Bundle bundle = getIntent().getExtras();
        m = bundle.getInt("posit");
        binding.setReserva(Info.data.get(m));
    }
}
