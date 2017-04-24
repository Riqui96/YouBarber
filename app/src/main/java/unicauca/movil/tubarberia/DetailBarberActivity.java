package unicauca.movil.tubarberia;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import unicauca.movil.tubarberia.databinding.ActivityDetailBarberiaBinding;
import unicauca.movil.tubarberia.util.Info;

public class DetailBarberActivity extends AppCompatActivity {

    ActivityDetailBarberiaBinding binding;
    public static final String EXTRA_POS ="pos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_barberia);

        int pos = getIntent().getIntExtra(EXTRA_POS,0); //asumo que llega posicion bajo esa etiqueta

        binding.setBarber(Info.data.get(pos));


    }
}
